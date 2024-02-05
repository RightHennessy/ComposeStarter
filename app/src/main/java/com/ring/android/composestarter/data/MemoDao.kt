package com.ring.android.composestarter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ring.android.composestarter.data.MemoEntity.Companion.COLUMN_ID
import com.ring.android.composestarter.data.MemoEntity.Companion.TABLE_NAME

@Dao
interface MemoDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getMemos(): List<MemoEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = :id")
    fun getMemo(id: Int): MemoEntity

    @Insert
    fun insertMemo(memo: MemoEntity)

    @Delete
    fun deleteMemo(memo: MemoEntity)

    @Update
    fun updateMemo(memo: MemoEntity)
}