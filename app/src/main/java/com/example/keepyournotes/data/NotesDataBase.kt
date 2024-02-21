package com.example.keepyournotes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [note::class], version = 1)
abstract class NotesDataBase : RoomDatabase(){

    abstract fun noteDao(): NoteDao

}