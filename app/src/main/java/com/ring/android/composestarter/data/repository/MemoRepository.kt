package com.ring.android.composestarter.data.repository

import com.ring.android.composestarter.data.MemoDao
import com.ring.android.composestarter.data.MemoEntity.Companion.toEntity
import com.ring.android.composestarter.domain.Memo
import com.ring.android.composestarter.domain.Memo.Companion.toDomain

class MemoRepository(
    private val memoDao: MemoDao
) {

    fun addMemo(memo: Memo) {
        memoDao.insertMemo(memo.toEntity())
    }

    fun deleteMemo(memo: Memo) {
        memoDao.deleteMemo(memo.toEntity())
    }

    fun updateMemo(memo: Memo) {
        memoDao.updateMemo(memo.toEntity())
    }

    fun getMemos(): List<Memo> {
        return memoDao.getMemos().map { it.toDomain() }
    }

    fun getMemo(id: Int): Memo {
        return memoDao.getMemo(id).toDomain()
    }
}