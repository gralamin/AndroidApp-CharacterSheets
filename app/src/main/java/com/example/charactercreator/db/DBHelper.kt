package com.example.charactercreator.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.charactercreator.db.contracts.CharacterImageContract
import com.example.charactercreator.db.contracts.CharacterSummaryContract
import com.example.charactercreator.db.contracts.SheetDataContract

// Might be better to have multiple helpers, but I have elected to go to a single one for all tables.
class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CharacterImageContract.SQL_CREATE_ENTRIES)
        db.execSQL(CharacterSummaryContract.SQL_CREATE_ENTRIES)
        db.execSQL(SheetDataContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // I'm not bothering to preserve my own data here, so simply replace the data.
        db.execSQL(SheetDataContract.SQL_DELETE_ENTRIES)
        db.execSQL(CharacterSummaryContract.SQL_DELETE_ENTRIES)
        db.execSQL(CharacterImageContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "CharacterCreator.db"
    }
}