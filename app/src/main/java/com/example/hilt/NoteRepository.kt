package com.example.hilt

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(
    private val noteDAO: NoteDAO
) {
    suspend fun getNote() : Note {
        return withContext(Dispatchers.IO){
            noteDAO.getNote()[0]
        }
    }

    suspend fun saveNote(note : Note) {
        withContext(Dispatchers.IO) {
            noteDAO.insert(note)
        }
    }
}