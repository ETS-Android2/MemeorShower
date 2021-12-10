package com.example.memeorshower.database.imagetmp

import androidx.room.*

@Dao
interface ImageTmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertByReplacement(image: List<ImageTmp>)

    @Query("SELECT * FROM image_tmp_table ORDER BY id ASC")
    fun getAll(): List<ImageTmp>

    @Query("SELECT * FROM image_tmp_table WHERE id = :id ")
    fun getByID(id: String): ImageTmp

    @Delete
    fun delete(imgtmp: ImageTmp)
}