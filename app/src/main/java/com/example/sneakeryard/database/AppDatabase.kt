package com.example.sneakeryard.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = [ShoeFromDatabase::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun ShoeDao(): ShoeDao
}