package com.ring.android.composestarter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ring.android.composestarter.data.MemoEntity.Companion.TABLE_NAME
import com.ring.android.composestarter.domain.Memo

@Entity(tableName = TABLE_NAME)
data class MemoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = COLUMN_TITLE) val title: String,
    @ColumnInfo(name = COLUMN_CONTENT) val content: String,
    @ColumnInfo(name = COLUMN_IMAGE) val image: String?
) {
    companion object {
        const val TABLE_NAME = "memo"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_CONTENT = "content"
        const val COLUMN_IMAGE = "image"
        fun Memo.toEntity(): MemoEntity =
            MemoEntity(title = title, content = content, image = image)
    }
}
