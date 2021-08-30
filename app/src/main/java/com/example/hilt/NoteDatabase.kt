package com.example.hilt

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDAO

    companion object {
        const val DATABASE_NAME = "worryNote.db"
    }
}