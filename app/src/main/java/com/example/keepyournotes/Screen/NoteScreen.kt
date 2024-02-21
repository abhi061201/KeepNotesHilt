package com.example.keepyournotes.Screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepyournotes.R
import com.example.keepyournotes.components.NoteButton
import com.example.keepyournotes.components.inputField
import com.example.keepyournotes.data.note
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<note>,
    onAddNote: (note) -> Unit,
    onRemoveNote: (note) -> Unit,

    ) {

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.Gray),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            inputField(
                text = title.value,
                label = "Add title",
                onTextChange = {
                    if (it.all {
                            it.isLetter() || it.isWhitespace()
                        }) title.value = it
                }
            )

            inputField(
                text = description.value,
                label = "Add Description",
                onTextChange = {
                    if (it.all {
                            it.isLetter() || it.isWhitespace()
                        }) description.value = it
                }
            )


        }
        NoteButton(text = "Save", onclick = {
            onAddNote(
                note(
                    title = title.value,
                    description = description.value,
//                    currentDate = LocalDateTime.now()
                )
            )
        })
        Divider()
        LazyColumn {
            items(notes) {
                NoteItem(note = it, onClick = {
                    onRemoveNote(it)
                })
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun noteScreenPreview() {
    NoteScreen(
        notes = emptyList(),
        onAddNote = {},
        onRemoveNote = {}
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteItem(
    note: note,
    onClick: (note) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier
            .padding(6.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xffDFE6EB),
        shadowElevation = 6.dp,

        ) {
        Column(
            modifier
                .clickable {
                    onClick.invoke(note)
                }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(note.title, style = MaterialTheme.typography.bodyLarge)
            Text(note.description, style = MaterialTheme.typography.bodyMedium)
//            Text(
//                note.currentDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
//                style = MaterialTheme.typography.labelMedium,
//            )


        }

    }
}