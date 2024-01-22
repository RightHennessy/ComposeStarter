package com.ring.android.composestarter.ui.memolist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ring.android.composestarter.DUMMY_DATA
import com.ring.android.composestarter.Memo
import com.ring.android.composestarter.ui.theme.ComposeStarterTheme

@Preview(showSystemUi = true)
@Composable
fun MemoListPreview() {
    ComposeStarterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MemoList(memos = DUMMY_DATA)
        }
    }
}

@Composable
fun MemoList(memos: List<Memo>) {
    LazyColumn(
    ) {
        itemsIndexed(memos) { idx, item ->
            MemoItem(memo = item)
        }
    }
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
fun MemoPreview() {
    ComposeStarterTheme {
        MemoItem(memo = DUMMY_DATA[0])
    }
}