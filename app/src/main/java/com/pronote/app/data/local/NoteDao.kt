package com.pronote.app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pronote.app.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE title LIKE '%' || :query || '%'")
    fun findByTitle(query: String): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id: Int): Flow<Note?>

    @Update
    suspend fun updateNote(note: Note)

    @Insert
    suspend fun insert(users: Note)

    @Delete
    suspend fun delete(user: Note)
}