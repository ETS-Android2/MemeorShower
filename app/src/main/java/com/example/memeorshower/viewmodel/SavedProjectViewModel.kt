package com.example.memeorshower.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeorshower.database.AppDatabase
import com.example.memeorshower.database.savedproject.SavedProject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SavedProjectViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: List<SavedProject>
    private val prjDao = AppDatabase.getDatabase(application).savedProjectDao()

    init {
        readAllData = prjDao.getAll()
    }

    fun addProject(savedProject: SavedProject){
        viewModelScope.launch(Dispatchers.IO) {
            prjDao.addProject(savedProject)
        }
    }

    fun getProjects(): List<SavedProject>{
        return readAllData;
    }

}