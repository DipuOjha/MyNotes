package com.example.mynotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities=[Note::class], version = 1, exportSchema = false)
abstract class Dbclass:RoomDatabase() {
    /*  abstract fun getBookDao():BookDao
    abstract fun getCategoryDao():CategoryDao*/
    abstract fun getNoteDao(): NotesDao

    companion object {


        @Volatile
        private var INSTANCE: Dbclass? = null
        fun getInstance(context: Context): Dbclass? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Dbclass::class.java,
                        "notes_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }

        }


    }
}