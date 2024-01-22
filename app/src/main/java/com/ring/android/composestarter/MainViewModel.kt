package com.ring.android.composestarter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ring.android.composestarter.ui.ScreenState
import com.ring.android.composestarter.ui.ScreenState.EDIT
import com.ring.android.composestarter.ui.ScreenState.MEMO_LIST

class MainViewModel : ViewModel() {
    var screenState: MutableState<ScreenState> = mutableStateOf(MEMO_LIST)

    fun moveToMemoList() {
        screenState.value = MEMO_LIST
    }

    fun moveToEdit() {
        screenState.value = EDIT
    }
}