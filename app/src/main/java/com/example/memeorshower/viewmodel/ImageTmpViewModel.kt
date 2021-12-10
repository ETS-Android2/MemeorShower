package com.example.memeorshower.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeorshower.database.AppDatabase
import com.example.memeorshower.database.imagetmp.ImageTmp
import com.example.memeorshower.database.texttmp.TextTmp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageTmpViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: List<ImageTmp>
    private val imgDao = AppDatabase.getDatabase(application).imagetmpDao()

    init {
        readAllData = imgDao.getAll()
    }

    fun addImage(imgtmp: ImageTmp){
        viewModelScope.launch(Dispatchers.IO) {
            imgDao.addImage(imgtmp)
        }
    }

}