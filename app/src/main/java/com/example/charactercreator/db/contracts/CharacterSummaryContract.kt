package com.example.charactercreator.db.contracts

import android.provider.BaseColumns

object CharacterSummaryContract {

    // Table contents are grouped together in an anonymous object.
    object CharacterSummary : BaseColumns {
        const val TABLE_NAME = "sheet_summary"
        const val COLUMN_NAME_CHARACTER_IMAGE = "img_id"
        const val COLUMN_NAME_SHEET_TYPE = "sheet_type"
        const val COLUMN_NAME_SHEET_NAME = "name"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${CharacterSummary.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${CharacterSummary.COLUMN_NAME_CHARACTER_IMAGE} INTEGER," +
                "${CharacterSummary.COLUMN_NAME_SHEET_TYPE} TEXT," +
                "${CharacterSummary.COLUMN_NAME_SHEET_NAME} TEXT," +
                "FOREIGN KEY(${CharacterSummary.COLUMN_NAME_CHARACTER_IMAGE}) REFERENCES ${CharacterImageContract.CharacterImage.TABLE_NAME}(${BaseColumns._ID}) )"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${CharacterSummary.TABLE_NAME}"
}