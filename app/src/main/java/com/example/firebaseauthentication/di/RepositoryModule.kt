package com.example.firebaseauthentication.di

import com.example.firebaseauthentication.data.AuthRepositoryImpl
import com.example.firebaseauthentication.model.repo.AuthRepository
import kotlinx.coroutines.NonCancellable.get
import org.koin.core.scope.get
import org.koin.dsl.module

val repoModule = module {
    single<AuthRepository>{ AuthRepositoryImpl() }
}