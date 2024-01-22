package com.ring.android.composestarter.domain

data class Memo(
    val title: String,
    val content: String,
    val image: String?
) {
    companion object {
        val DEFAULT = Memo("", "", null)
    }
}