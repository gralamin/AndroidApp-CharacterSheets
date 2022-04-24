package com.example.charactercreator.db.contracts

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.charactercreator.models.CharacterSummary

object SummaryDataConverter {

    // POST /summary
    fun writeModel(db: SQLiteDatabase, model: CharacterSummary): Long {

        // TODO: If Character image exists, first dump it into the CharacterImage table, then use
        // that id here.
        val values = ContentValues().apply {
            put(
                CharacterSummaryContract.CharacterSummary.COLUMN_NAME_CHARACTER_IMAGE,
                model.characterImage
            )
            put(
                CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_NAME,
                model.characterName
            )
            put(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_TYPE, model.sheetType)
        }

        return db.insert(
            CharacterSummaryContract.CharacterSummary.TABLE_NAME,
            null,
            values
        )
    }

    // GET all models
    fun readModels(db: SQLiteDatabase): List<CharacterSummary> {
        // To get the images all at once, use a JOIN, but JOIN needs raw query
        // Specifically want LEFT OUTER JOIN because we want all the values in Character Summary
        // Even if the foreign key is null
        val cursor = db.rawQuery("SELECT * " +
                "FROM ${CharacterSummaryContract.CharacterSummary.TABLE_NAME} a " +
                "LEFT OUTER JOIN ${CharacterImageContract.CharacterImage.TABLE_NAME} b " +
                "ON a.${CharacterSummaryContract.CharacterSummary.COLUMN_NAME_CHARACTER_IMAGE}=b.${BaseColumns._ID}", null)

        val result = mutableListOf<CharacterSummary>()

        with(cursor) {
            while (moveToNext()) {
                val model = CharacterSummary(
                    getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    getString(getColumnIndexOrThrow(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_NAME)),
                    getString(getColumnIndexOrThrow(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_NAME)),
                    getString(getColumnIndexOrThrow(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_CHARACTER_IMAGE))
                )
                result.add(model)
            }
        }
        cursor.close()

        return result
    }

    // PUT /summary/:id
    fun updateModel(db: SQLiteDatabase, model: CharacterSummary) {
        // TODO handle updating images
        val values = ContentValues().apply {
            put(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_NAME, model.characterName)
            put(CharacterSummaryContract.CharacterSummary.COLUMN_NAME_SHEET_TYPE, model.sheetType)
        }

        // Which row to update, based on the ID
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(model.id.toString())
        val count = db.update(
            CharacterSummaryContract.CharacterSummary.TABLE_NAME,
            values,
            selection,
            selectionArgs)
        assert(count != 0)
    }

    // DELETE /summary/:id (but can do multiple at once)
    fun deleteModels(db: SQLiteDatabase, models: List<CharacterSummary>) {
        // TODO clean up unused images
        val selection = "${BaseColumns._ID} IM ?"
        val selectionArgs = models.map{ it.id.toString() }.toTypedArray()
        val deletedRows = db.delete(CharacterSummaryContract.CharacterSummary.TABLE_NAME, selection, selectionArgs)
        assert(models.size == deletedRows)
    }
}