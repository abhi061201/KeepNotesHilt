package com.example.keepyournotes.data

import android.os.Build
import androidx.annotation.RequiresApi

class NotesDataStructure {
    companion object{

        var notes  = listOf<note>(

            note(
                title = "note 4",
                description = "hii this side radha "
            ),
            note(
                title = "note 5",
                description = "hii this side radha "
            ),
            note(
                title = "note 6",
                description = "hii this side radha "
            ),

        )
    }
}