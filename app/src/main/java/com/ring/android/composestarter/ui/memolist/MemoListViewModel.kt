package com.ring.android.composestarter.ui.memolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ring.android.composestarter.MemoApplication
import com.ring.android.composestarter.data.repository.MemoRepository
import com.ring.android.composestarter.domain.Memo

class MemoListViewModel(
    private val memoRepository: MemoRepository
) : ViewModel() {

    fun getMemos(): List<Memo> {
        return memoRepository.getMemos()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MemoListViewModel(
                    MemoApplication().repository
                )
            }
        }
    }
}