package com.example.memeorshower.database.imagetmp

import androidx.room.*
import com.example.memeorshower.database.texttmp.TextTmp

@Dao
interface ImageTmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertByReplacement(image: List<ImageTmp>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addImage(image: ImageTmp)

    @Query("SELECT * FROM image_tmp_table ORDER BY id ASC")
    fun getAll(): List<ImageTmp>

    @Query("SELECT * FROM image_tmp_table WHERE id = :id ")
    fun getByID(id: Int): ImageTmp

    @Delete
    fun delete(imgtmp: ImageTmp)
}