package com.example.sneakeryard.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query



@Dao
interface ShoeDao {

    @Suppress("AndroidUnresolvedRoomSqlReference")
    @Query("SELECT  * FROM  ShoeFromDatabase")
    fun getAll(): List<ShoeFromDatabase>

    @Insert
    fun insertAll(vararg shoes: ShoeFromDatabase)

}