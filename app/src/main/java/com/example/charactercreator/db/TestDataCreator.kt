package com.example.charactercreator.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.charactercreator.db.contracts.CharacterSummaryContract
import com.example.charactercreator.db.contracts.SummaryDataConverter
import com.example.charactercreator.models.CharacterSummary

object TestDataCreator {

    fun createTestData(db: SQLiteDatabase) {
        if (needToAdd(db)) {
            addTestData(db)
        }
    }

    private fun needToAdd(db: SQLiteDatabase): Boolean {
        // project is the columns we want
        val projection = arrayOf(BaseColumns._ID)

        // selection is any filtering we want to add

        val cursor = db.query(
            CharacterSummaryContract.CharacterSummary.TABLE_NAME,
            projection,
            null, // Don't use a where clause
            null, // Nothing to pass into where
            null, // Don't group rows
            null, // don't filter row groups'
            null // Use default order
        )

        with(cursor) {
            while (moveToNext()) {
                return false
            }
        }
        cursor.close()
        return true
    }

    private fun addTestData(db: SQLiteDatabase) {
        addImageData()
        addSummaryData(db)
        addSheetData()
    }

    private fun addImageData() {
        // No image data for testing
        return
    }

    private fun addSummaryData(db: SQLiteDatabase) {
        val CHARACTER_ONE = CharacterSummary(0, "Joe", "FATE", null)
        val CHARACTER_TWO = CharacterSummary(1, "Raphaël Ambrosius Costeau", "Disco Elysium", null)
        val CHARACTER_ThREE = CharacterSummary(2, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM", "MMMMMMMMMMMMMMMMMMMMMMMMM", null)
        val CHARACTER_FOUR = CharacterSummary(3, "Abasdasdasdasdasdasdasdsadasdasdads", "FATE", null)
        val CHARACTER_FIVE = CharacterSummary(4, "Cdzbcxcxxcxcxccxcxcxcxcxcxcxcxcxcxcxcxcxcx", "FATE", null)
        val CHARACTER_SIX = CharacterSummary(5, "Ef", "FATE", null)

        val ALL_CHARACTERS =  listOf(CHARACTER_ONE, CHARACTER_TWO, CHARACTER_ThREE, CHARACTER_FOUR,
            CHARACTER_FIVE, CHARACTER_SIX)

        for (character in ALL_CHARACTERS) {
            SummaryDataConverter.writeModel(db, character)
        }
    }

    private fun addSheetData() {
        // TODO
        return
    }
}