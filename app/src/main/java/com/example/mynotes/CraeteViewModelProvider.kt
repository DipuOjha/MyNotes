package com.example.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CraeteViewModelProvider(var notesRepo: NotesRepo) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       // return super.create(modelClass)
        if(modelClass.isAssignableFrom(CreateViewModel::class.java)) {
            return CreateViewModel(notesRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")

    }


}