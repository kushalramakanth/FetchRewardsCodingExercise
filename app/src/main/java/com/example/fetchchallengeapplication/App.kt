package com.example.fetchchallengeapplication

import android.app.Application
import android.content.Context

// This is the first part of the app executed when this app is installed in a new device. I used this block
// to store the context of the entire application (applicationContext) so that it can be used everywhere
// I also need to edit the Manifest and added the line android:name=".App" for this to work
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        lateinit var context: Context
    }
}