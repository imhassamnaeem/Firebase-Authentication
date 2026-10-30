package com.example.firebaseauthentication.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class DiManager private constructor(private val application: Context) {
    
    companion object {
        fun initialize(application: Context) {
            DiManager(application)
        }
    }

    init {
        startKoin {
            androidContext(application)
            modules(getModules())
        }
    }

    private val repoList
        get() = listOf(
            repoModule
        )

    private val viewModelList
        get() = listOf(
            viewModelModule
        )

    private val moduleList
        get() = listOf(
            viewModelList,
            repoList
        )

    private fun getModules(): List<Module> {
        return moduleList.flatten()
    }
}