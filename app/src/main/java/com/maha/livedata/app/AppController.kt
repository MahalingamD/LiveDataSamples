package com.maha.livedata.app

import android.app.Application
import androidx.room.Room
import com.maha.livedata.db.database.AppDatabase

class AppController: Application() {

    override fun onCreate() {
        super.onCreate()

        Room.databaseBuilder(this, AppDatabase::class.java, "post_db")
            .fallbackToDestructiveMigration()
            .build()
    }


}