package com.muhammadahmad.notenest.repository

import androidx.lifecycle.LiveData
import com.muhammadahmad.notenest.data.Note
import com.muhammadahmad.notenest.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}

