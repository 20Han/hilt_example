package com.example.hilt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDAO {
    @Query("SELECT * FROM Notes")
    fun getNote() : List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note : Note) : Long
}