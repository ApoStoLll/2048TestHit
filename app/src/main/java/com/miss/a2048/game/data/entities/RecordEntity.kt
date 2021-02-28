package com.miss.a2048.game.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db")
data class RecordEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int? = null,

    @ColumnInfo(name = "Score")
    var score : String,

    @ColumnInfo(name = "Time")
    var time : String
)