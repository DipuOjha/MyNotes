package com.example.mynotes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes-table")
data class Note(@PrimaryKey(autoGenerate = false) var id:Int,var title:String,var des:String)
