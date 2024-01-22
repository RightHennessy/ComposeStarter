package com.ring.android.composestarter.ui.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ring.android.composestarter.ui.theme.ComposeStarterTheme

@Preview(showSystemUi = true)
@Composable
fun MemoEditPreview() {
    ComposeStarterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MemoEdit()
        }
    }
}

@Composable
fun MemoEdit() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var content by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(
            value = title,
            onValueChange = { input -> title = input },
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            )
        )
        TextField(
            value = content,
            onValueChange = { input -> content = input },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            )
        )
    }
}