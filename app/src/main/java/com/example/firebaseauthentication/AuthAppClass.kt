package com.example.firebaseauthentication

import android.app.Application
import com.example.firebaseauthentication.di.DiManager

class AuthAppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        DiManager.initialize(application = this)
    }
}