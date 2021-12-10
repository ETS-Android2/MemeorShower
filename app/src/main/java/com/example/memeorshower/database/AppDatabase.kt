package com.example.memeorshower.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memeorshower.database.imagetmp.ImageTmp
import com.example.memeorshower.database.imagetmp.ImageTmpDao
import com.example.memeorshower.database.savedproject.SavedProject
import com.example.memeorshower.database.savedproject.SavedProjectDao
import com.example.memeorshower.database.texttmp.TextTmp
import com.example.memeorshower.database.texttmp.TextTmpDao

@Database(entities =arrayOf(ImageTmp::class, TextTmp::class, SavedProject::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imagetmpDao(): ImageTmpDao
    abstract fun texttmpDao(): TextTmpDao
    abstract fun savedProjectDao(): SavedProjectDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
//                    .createFromAsset("database/memeorshower.db")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}