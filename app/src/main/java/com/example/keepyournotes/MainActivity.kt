package com.example.keepyournotes

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.keepyournotes.Screen.NoteScreen
import com.example.keepyournotes.Screen.NotesViewModel
import com.example.keepyournotes.data.NotesDataStructure
import com.example.keepyournotes.data.note
import com.example.keepyournotes.ui.theme.KeepYourNotesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KeepYourNotesTheme {
                NotesScreen()
            }
        }
    }
}


@Composable
fun NotesScreen(notesViewModel: NotesViewModel= viewModel()) {
    val notes = notesViewModel.getAllNotes()
    NoteScreen(

        notes = notes,
        onRemoveNote = {
            notesViewModel.removeNote(it)
        },
        onAddNote = {
            notesViewModel.addNote(it)
        }
    )
}