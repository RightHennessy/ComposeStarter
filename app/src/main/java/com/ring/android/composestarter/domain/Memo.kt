package com.ring.android.composestarter.domain

import com.ring.android.composestarter.data.MemoEntity

data class Memo(
    val id: Int = 0,
    val title: String,
    val content: String,
    val image: String?
) {
    companion object {
        val DEFAULT = Memo(0, "", "", null)
        fun MemoEntity.toDomain(): Memo = Memo(id, title, content, image)
    }
}