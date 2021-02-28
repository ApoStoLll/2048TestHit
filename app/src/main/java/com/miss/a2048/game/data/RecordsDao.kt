package com.miss.a2048.game.data

import androidx.room.*
import com.miss.a2048.game.data.entities.RecordEntity

@Dao
interface RecordsDao{
    @Query("SELECT * FROM db")
    fun get() : List<RecordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(a: RecordEntity)

    @Delete
    fun remove(a: RecordEntity)

    @Query("SELECT * FROM db WHERE id = :id")
    fun getId(id : Int) : RecordEntity
}
