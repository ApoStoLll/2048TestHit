package com.miss.a2048.game.di

import android.content.Context
import androidx.room.Room
import com.miss.a2048.game.data.RecordsDB
import org.koin.dsl.module

val dataModule = module {
    single {
        provideDb(get())
    }
}


fun provideDb(context : Context): RecordsDB {
    return Room.databaseBuilder(context, RecordsDB::class.java, "db")
        .fallbackToDestructiveMigration()
        .build()
}