package com.vivek.quotes

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Quotes : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("QuotesApp", "Application initialized")
    }
}