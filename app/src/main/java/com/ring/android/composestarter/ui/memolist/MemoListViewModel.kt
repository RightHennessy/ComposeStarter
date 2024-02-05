package com.ring.android.composestarter.ui.memolist

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
import kotlinx.coroutines.withContext

class MemoListViewModel(
    private val memoRepository: MemoRepository
) : ViewModel() {
    private var _memos: MutableState<List<Memo>> = mutableStateOf(emptyList())
    val memos: State<List<Memo>>
        get() = _memos

    fun getMemos() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                memoRepository.getMemos()
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _memos.value = it
                }
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MemoListViewModel(
                    MemoRepository(
                        MemoDatabase.getInstance(MemoApplication.getApplicationContext()).memoDao()
                    )
                )
            }
        }
    }
}