package com.example.memeorshower.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memeorshower.database.imagetmp.ImageTmp
import com.example.memeorshower.database.imagetmp.ImageTmpDao
import com.example.memeorshower.database.texttmp.TextTmp
import com.example.memeorshower.database.texttmp.TextTmpDao

@Database(entities =[ImageTmp::class, TextTmp::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imagetmpDao(): ImageTmpDao
    abstract fun texttmpDao(): TextTmpDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/memeorshower.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}