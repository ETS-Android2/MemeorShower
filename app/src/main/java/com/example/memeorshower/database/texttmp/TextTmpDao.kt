package com.example.memeorshower.database.texttmp

import androidx.room.*
import com.example.memeorshower.database.imagetmp.ImageTmp

@Dao
interface TextTmpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertByReplacement(texts: List<TextTmp>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addText(text: TextTmp)

    @Query("SELECT * FROM text_tmp_table ORDER BY id ASC")
    fun getAll(): List<TextTmp>

    @Query("SELECT * FROM text_tmp_table WHERE id = :id ")
    fun getByID(id: Int): TextTmp

    @Delete
    fun delete(txttmp: ImageTmp)
}