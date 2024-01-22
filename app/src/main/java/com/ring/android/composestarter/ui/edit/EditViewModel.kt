package com.ring.android.composestarter.ui.edit

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ring.android.composestarter.data.DUMMY_DATA
import com.ring.android.composestarter.domain.Memo

class EditViewModel : ViewModel() {

    private var _memo: MutableState<Memo> = mutableStateOf(Memo.DEFAULT)
    val memo: State<Memo>
        get() = _memo

    fun saveMemo() {
        DUMMY_DATA.add(memo.value)
    }

    fun updateTitle(input: String) {
        _memo.value = memo.value.copy(title = input)
    }

    fun updateContent(input: String) {
        _memo.value = memo.value.copy(content = input)
    }
}