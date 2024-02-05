package com.ring.android.composestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ring.android.composestarter.ui.ScreenState.EDIT
import com.ring.android.composestarter.ui.ScreenState.MEMO_LIST
import com.ring.android.composestarter.ui.edit.EditScreen
import com.ring.android.composestarter.ui.memolist.MemoListScreen
import com.ring.android.composestarter.ui.theme.ComposeStarterTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen(viewModel)
        }
    }
}

@Composable
fun Screen(viewModel: MainViewModel) {
    ComposeStarterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            when (viewModel.screenState.value) {
                MEMO_LIST -> MemoListScreen(moveToEdit = viewModel::moveToEdit)
                EDIT -> EditScreen(moveToMemoList = viewModel::moveToMemoList)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    Screen(MainViewModel())
}
