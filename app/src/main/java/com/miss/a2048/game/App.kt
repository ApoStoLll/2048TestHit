package com.miss.a2048.game

import android.app.Application
import com.miss.a2048.game.di.appModule
import com.miss.a2048.game.di.dataModule
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

const val NOTIFICATION_CHANNEL = "horo_games_notification"


class App : Application() {

    private val ONESIGNAL_APP_ID = "b22a3e10-129b-4aa7-8905-c8e0b873e0f1"

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appModule, dataModule)
        }
    }
}