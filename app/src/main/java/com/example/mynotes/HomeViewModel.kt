package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(var notesRepo: NotesRepo):ViewModel() {
    fun getNotes():LiveData<List<Note>> {
         return notesRepo.noteList


    }
}