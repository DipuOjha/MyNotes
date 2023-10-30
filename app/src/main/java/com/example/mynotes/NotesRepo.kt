package com.example.mynotes

class NotesRepo(var notesDao: NotesDao) {
   // var dao =notesDao
    var noteList = notesDao.getNotes()

    suspend fun insert(note: Note){
        notesDao.insert(note)
    }
}