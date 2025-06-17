package com.pronote.app.data.repository

import com.pronote.app.data.local.NoteDao
import com.pronote.app.data.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao)  {
    fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAll()
    }
    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }
    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }
    fun searchNotes(query: String): Flow<List<Note>> {
        return noteDao.findByTitle(query)
    }
    fun getNoteById(id: Int): Flow<Note?> = noteDao.getNoteById(id)

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

}