package com.wearerommies.roomie

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class RoomieApp : Application() {
    override fun onCreate() {
        super.onCreate()

        setTimber()
        setDarkMode()
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
