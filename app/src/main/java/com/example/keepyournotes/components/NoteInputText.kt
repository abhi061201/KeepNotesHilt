package com.example.keepyournotes.components

import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun inputField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeaction: () -> Unit = {},


    ) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeaction()
                keyboardController?.hide()
            }
        ),
        maxLines = maxLine,
        label= {
            Text(text = label)
        },
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()




    )
}


@Composable
fun NoteButton(
    modifier: Modifier=Modifier,
    text : String,
    onclick: ()-> Unit,
    enable : Boolean = true
) {
    Button(
        onClick = onclick,
        shape =  CircleShape,
        enabled = enable,
        modifier = modifier

        ) {
        Text(text = text)
    }
}