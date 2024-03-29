package com.ring.android.composestarter.ui.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showSystemUi = true)
@Composable
fun EditScreenPreview() {
    EditScreen {}
}

@Composable
fun EditScreen(
    editViewModel: EditViewModel = viewModel(factory = EditViewModel.Factory),
    moveToMemoList: () -> Unit
) {
    Column {
        MemoEditHeader(moveToMemoList, editViewModel)
        MemoEdit(editViewModel)
    }
}

@Composable
fun MemoEditHeader(moveToMemoList: () -> Unit, editViewModel: EditViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = "뒤로가기", fontSize = 12.sp, modifier = Modifier.clickable {
            moveToMemoList()
        })
        Text(
            text = "완료",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(1.dp, color = Color.Gray)
                .background(color = Color.Gray)
                .padding(4.dp)
                .clickable {
                    editViewModel.saveMemo()
                    moveToMemoList()
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MemoEditHeaderPreview() {
    MemoEditHeader({}, viewModel())
}

@Composable
fun MemoEdit(editViewModel: EditViewModel = viewModel(factory = EditViewModel.Factory)) {
    Column {
        TextField(
            // value = editViewModel.memo.value.title,
            value = "",
            onValueChange = { input -> editViewModel.updateTitle(input = input) },
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            label = { Text(text = "제목을 입력해주세요") }
        )

        TextField(
            // value = editViewModel.memo.value.image ?: "",
            value = "",
            onValueChange = { input -> editViewModel.updateImage(input = input) },
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            label = { Text(text = "이미지를 입력해주세요") }
        )

        TextField(
            // value = editViewModel.memo.value.content,
            value = "",
            onValueChange = { input -> editViewModel.updateContent(input) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White
            ),
            label = { Text(text = "내용을 입력해주세요") }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MemoEditPreview() {
    MemoEdit(viewModel())
}