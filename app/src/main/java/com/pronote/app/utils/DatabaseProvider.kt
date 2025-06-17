package com.pronote.app.utils

import android.content.Context
import androidx.room.Room
import com.pronote.app.data.local.AppDatabase

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "notes_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
