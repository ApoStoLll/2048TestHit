package com.miss.a2048.game.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.miss.a2048.game.data.entities.RecordEntity

@Database(entities = [RecordEntity::class], version = 1)
abstract class RecordsDB : RoomDatabase(){
    abstract fun dao() : RecordsDao
}