package com.ring.android.composestarter.ui.memolist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ring.android.composestarter.domain.Memo

@Preview(showSystemUi = true)
@Composable
fun MemoListScreenPreview() {
    MemoListScreen {}
}

@Composable
fun MemoListScreen(
    memoListViewModel: MemoListViewModel = viewModel(factory = MemoListViewModel.Factory),
    moveToEdit: () -> Unit
) {
    Column {
        MemoListHeader(moveToEdit)
        MemoList(memoListViewModel)
    }
}

@Composable
fun MemoList(viewModel: MemoListViewModel) {
    viewModel.getMemos()
    val memos by viewModel.memos

    LazyColumn(
    ) {
        itemsIndexed(memos) { idx, item ->
            MemoItem(memo = item)
        }
    }
}

@Composable
fun MemoListHeader(moveToEdit: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "나의 메모 목록", fontSize = 20.sp)
        Text(
            text = "추가",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .border(1.dp, color = Color.Gray)
                .background(color = Color.Gray)
                .padding(4.dp)
                .clickable { moveToEdit() },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MemoListHeaderPreview() {
    MemoListHeader {}
}


@Composable
fun MemoItem(memo: Memo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(1.dp, color = Color.Black)
            .padding(8.dp)
    ) {
        Text(text = memo.title)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = memo.content, fontSize = 12.sp, maxLines = 2, lineHeight = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MemoItemPreview() {
    MemoItem(memo = Memo.DEFAULT)
}