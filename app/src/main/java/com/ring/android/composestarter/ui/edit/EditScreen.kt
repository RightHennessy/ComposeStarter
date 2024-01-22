package com.ring.android.composestarter.ui.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun EditScreenPreview() {
    EditScreen()
}

@Composable
fun EditScreen() {
    Column {
        MemoEditHeader()
        MemoEdit()
    }
}

@Composable
fun MemoEditHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "메모 편집", fontSize = 20.sp)
        Text(
            text = "완료",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(1.dp, color = Color.Gray)
                .background(color = Color.Gray)
                .padding(4.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MemoEditHeaderPreview() {
    MemoEditHeader()
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

@Preview(showSystemUi = true)
@Composable
fun MemoEditPreview() {
    MemoEdit()
}