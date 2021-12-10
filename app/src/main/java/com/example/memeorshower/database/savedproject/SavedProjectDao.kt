package com.example.memeorshower.database.savedproject

import androidx.room.*
import com.example.memeorshower.database.savedproject.SavedProject
import com.example.memeorshower.database.texttmp.TextTmp

@Dao
interface SavedProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertByReplacement(project: List<SavedProject>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProject(project: SavedProject)

    @Query("SELECT * FROM saved_project_table ORDER BY id ASC")
    fun getAll(): List<SavedProject>

    @Query("SELECT * FROM saved_project_table WHERE id = :id ")
    fun getByID(id: Int): SavedProject

    @Delete
    fun delete(project: SavedProject)
}