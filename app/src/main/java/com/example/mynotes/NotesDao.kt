package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes:Note)
    @Query("Select * from `notes-table`")
    fun getNotes():LiveData<List<Note>>
}