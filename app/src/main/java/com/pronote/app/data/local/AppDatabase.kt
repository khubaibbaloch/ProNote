package com.pronote.app.data.local

import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import com.pronote.app.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}