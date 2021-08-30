package com.example.hilt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate= true)
    var id : Long = 0,

    @ColumnInfo(name = "Title")
    var title: String,

    @ColumnInfo(name = "Description")
    var description: String
)
