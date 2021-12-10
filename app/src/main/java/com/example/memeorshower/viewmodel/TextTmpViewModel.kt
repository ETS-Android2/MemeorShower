package com.example.memeorshower.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.memeorshower.database.AppDatabase
import com.example.memeorshower.database.texttmp.TextTmp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TextTmpViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: List<TextTmp>
    private val txtDao = AppDatabase.getDatabase(application).texttmpDao()

    init {
        AppDatabase.getDatabase(application)
        readAllData = txtDao.getAll()
    }

    fun addText(txttmp: TextTmp){
        viewModelScope.launch(Dispatchers.IO) {
            txtDao.addText(txttmp)
        }
    }
}
