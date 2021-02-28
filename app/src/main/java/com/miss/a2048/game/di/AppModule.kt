package com.miss.a2048.game.di

import com.miss.a2048.game.ui.records.RecordsViewModel
import com.miss.a2048.game.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        SplashViewModel()
    }
    viewModel {
        RecordsViewModel(get())
    }
}