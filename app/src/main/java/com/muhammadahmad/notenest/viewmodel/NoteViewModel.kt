package com.muhammadahmad.notenest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.muhammadahmad.notenest.data.Note
import com.muhammadahmad.notenest.data.NoteDatabase
import com.muhammadahmad.notenest.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
}

