package com.maha.livedata.db.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.maha.livedata.db.dao.PostDao
import com.maha.livedata.db.entity.Post
import java.util.logging.Logger

@Database(
    entities = [Post::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {


    companion object {
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "post_db"
                )
                    .allowMainThreadQueries()
                    .addCallback(CALLBACK)
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

    abstract fun postModel(): PostDao

}

private val CALLBACK = object : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        Log.e("DB Created", "Successfully")
    }
}
