package com.maha.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maha.livedata.db.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mAppDatabase: AppDatabase by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        clickListener()
    }

    private fun clickListener() {

        button1.setOnClickListener {

        }

        button2.setOnClickListener {

        }

        button3.setOnClickListener {

        }
    }
}
