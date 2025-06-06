package com.muhammadahmad.notenest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteById(id: Int)

    // Or simply
    @Delete
    suspend fun delete(note: Note)
}
