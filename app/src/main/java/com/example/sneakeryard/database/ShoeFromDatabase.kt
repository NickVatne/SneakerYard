package com.example.sneakeryard.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class ShoeFromDatabase(
    @PrimaryKey(autoGenerate = true) val uid: Int?,

    @ColumnInfo val title: String,

    @ColumnInfo val price: Double
)