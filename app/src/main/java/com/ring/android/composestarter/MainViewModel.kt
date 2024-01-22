package com.ring.android.composestarter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ring.android.composestarter.ui.ScreenState
import com.ring.android.composestarter.ui.ScreenState.EDIT
import com.ring.android.composestarter.ui.ScreenState.MEMO_LIST

class MainViewModel : ViewModel() {
    private var _screenState: MutableState<ScreenState> = mutableStateOf(MEMO_LIST)
    val screenState: State<ScreenState>
        get() = _screenState

    fun moveToMemoList() {
        _screenState.value = MEMO_LIST
    }

    fun moveToEdit() {
        _screenState.value = EDIT
    }
}