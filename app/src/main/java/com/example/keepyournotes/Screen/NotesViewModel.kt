package com.example.keepyournotes.Screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

import androidx.lifecycle.ViewModel
import com.example.keepyournotes.data.NotesDataStructure
import com.example.keepyournotes.data.note

class NotesViewModel: ViewModel() {
   private val notesList =  mutableStateListOf<note>()

    init {
        notesList.addAll(NotesDataStructure.notes)

    }
    fun addNote(note: note){
        notesList.add(note)
    }
    fun removeNote(note: note){
        notesList.remove(note)
    }

    fun getAllNotes(): List<note>{
        return notesList
    }

}