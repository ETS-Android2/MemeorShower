package com.example.memeorshower.database.texttmp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_tmp_table")
data class TextTmp(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "text") val text: String
)
