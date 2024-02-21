package com.example.keepyournotes.di

import android.content.Context
import androidx.room.Room
import com.example.keepyournotes.data.NoteDao
import com.example.keepyournotes.data.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun providesNotesDao(notesDataBase: NotesDataBase): NoteDao{
        return notesDataBase.noteDao()
    }

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): NotesDataBase{
        return Room.databaseBuilder(
            context,
            NotesDataBase::class.java,
            "notes_db")
            .fallbackToDestructiveMigration()
            .build()
    }



}