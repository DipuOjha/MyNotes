package com.example.mynotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateViewModel(var notesRepo: NotesRepo): ViewModel(){
  // lateinit var notesList:ArrayList<Note>
    fun addNote(note:Note) {
        Log.d("Hi", "note added")
        viewModelScope.launch(Dispatchers.IO) {
            // notesList.add(note)
            notesRepo.insert(note)

        }
    }
   /* fun getNotes():ArrayList<Note>{
        return notesList
    }*/
}