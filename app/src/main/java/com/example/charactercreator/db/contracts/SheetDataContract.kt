package com.example.charactercreator.db.contracts

import android.provider.BaseColumns

object SheetDataContract {
    // Table contents are grouped together in an anonymous object.
    object SheetData : BaseColumns {
        const val TABLE_NAME = "sheet_data"
        const val COLUMN_NAME_SHEET_ID = "sheet_id"
        const val COLUMN_NAME_DATA_FIELD_ID = "data_field_id"
        const val COLUMN_NAME_DATA_STRING = "string_data"
        const val COLUMN_NAME_DATA_DOUBLE = "double_data"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${SheetData.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${SheetData.COLUMN_NAME_SHEET_ID} INTEGER, " +
                "${SheetData.COLUMN_NAME_DATA_FIELD_ID} TEXT NOT NULL," +
                "${SheetData.COLUMN_NAME_DATA_STRING} TEXT," +
                "${SheetData.COLUMN_NAME_DATA_DOUBLE} DOUBLE," +
                "FOREIGN KEY (${SheetData.COLUMN_NAME_SHEET_ID}) " +
                "REFERENCES ${CharacterSummaryContract.CharacterSummary.TABLE_NAME}(${BaseColumns._ID}) " +
                "ON DELETE CASCADE,"+
                "UNIQUE (${SheetData.COLUMN_NAME_SHEET_ID}, ${SheetData.COLUMN_NAME_DATA_FIELD_ID}) )"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${SheetData.TABLE_NAME}"
}