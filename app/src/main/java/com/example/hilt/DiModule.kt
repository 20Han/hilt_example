package com.example.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiModule {
    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase {
        return Room
            .databaseBuilder(
                context,
                NoteDatabase::class.java,
                NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteDAO(noteDB: NoteDatabase): NoteDAO {
        return noteDB.noteDao()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDAO: NoteDAO
    ) : NoteRepository{
        return NoteRepository(noteDAO)
    }
}