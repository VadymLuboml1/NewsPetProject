package com.galaziukvadym.newspetproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.galaziukvadym.newspetproject.data.database.LocalSavedNewsDatabase.Companion.DATABASE_VERSION

@Database(version = DATABASE_VERSION, entities = [NewsDatabaseDto::class])
abstract class LocalSavedNewsDatabase : RoomDatabase() {

    abstract val localSavedNewsDao: LocalSavedNewsDao

    companion object {
        const val DATABASE_NAME = "LOCAL_DATABASE_NAME"
        const val LOCAL_SAVED_NEWS_TABLE_NAME = "NEWS"
        const val DATABASE_VERSION = 1
    }
}

