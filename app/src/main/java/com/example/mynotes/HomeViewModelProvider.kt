package com.example.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HomeViewModelProvider(var repo:NotesRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repo) as T
            }

      //  return super.create(modelClass)
        throw IllegalArgumentException("Unknown ViewModel Class")

    }

}