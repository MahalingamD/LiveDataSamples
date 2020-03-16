package com.maha.livedata.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Post : Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "aId")
    var aId: Long = 0

    @ColumnInfo(name = "userId")
    var userId: String = ""

    @ColumnInfo(name = "id")
    var id: String = ""

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "body")
    var body: String = ""

}