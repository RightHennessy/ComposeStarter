package com.ring.android.composestarter.ui.edit

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ring.android.composestarter.MemoApplication
import com.ring.android.composestarter.data.MemoDatabase
import com.ring.android.composestarter.data.repository.MemoRepository
import com.ring.android.composestarter.domain.Memo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditViewModel(
    private val memoRepository: MemoRepository
) : ViewModel() {

    private var _memo: MutableState<Memo> = mutableStateOf(Memo.DEFAULT)
    val memo: State<Memo>
        get() = _memo

    fun saveMemo() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                memoRepository.addMemo(memo.value)
            }
        }
    }

    fun updateTitle(input: String) {
        _memo.value = memo.value.copy(title = input)
    }

    fun updateContent(input: String) {
        _memo.value = memo.value.copy(content = input)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                EditViewModel(
                    MemoRepository(
                        MemoDatabase.getInstance(MemoApplication.getApplicationContext()).memoDao()
                    )
                )
            }
        }
    }

}
