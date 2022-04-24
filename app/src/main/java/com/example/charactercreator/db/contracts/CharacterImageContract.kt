package com.example.charactercreator.db.contracts

import android.provider.BaseColumns

object CharacterImageContract {

    object CharacterImage : BaseColumns {
        const val TABLE_NAME = "character_image"
        const val COLUMN_NAME_IMAGE_PATH = "img_path"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${CharacterImage.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${CharacterImage.COLUMN_NAME_IMAGE_PATH} TEXT,"+
                "UNIQUE(${CharacterImage.COLUMN_NAME_IMAGE_PATH}) )"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${CharacterImage.TABLE_NAME}"
}