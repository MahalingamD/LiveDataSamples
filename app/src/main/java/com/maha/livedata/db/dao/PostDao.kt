package com.maha.livedata.db.dao

import androidx.room.*
import com.maha.livedata.db.entity.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(aPost: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(aPostList: ArrayList<Post>)

    @Delete
    fun delete(aPost: Post)


    @Query("Select * from Post")
    fun getAll() :List<Post>


    @Query("Select * from Post  where Id=(SELECT last_insert_rowid())")
    fun getLastInsertItem() :Post

    @Query("Select * from Post where aId= :aId")
    fun getParticularItem(aId:String) :Post
}