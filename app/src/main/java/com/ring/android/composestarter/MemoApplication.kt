package com.ring.android.composestarter

import android.app.Application
import android.content.Context
import com.ring.android.composestarter.data.MemoDatabase
import com.ring.android.composestarter.data.repository.MemoRepository

class MemoApplication : Application() {

    val database by lazy { MemoDatabase.getInstance(this) }
    val repository by lazy { MemoRepository(database.memoDao()) }

    init {
        INSTANCE = this
    }

    companion object {
        private lateinit var INSTANCE: MemoApplication

        fun getApplicationContext(): Context {
            return INSTANCE.applicationContext
        }
    }
}