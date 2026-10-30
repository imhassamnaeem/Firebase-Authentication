package com.example.firebaseauthentication.di

import com.example.firebaseauthentication.ui.presentation.home.HomeViewModel
import com.example.firebaseauthentication.ui.presentation.login.LoginViewModel
import com.example.firebaseauthentication.ui.presentation.signup.SignupViewModel
import com.example.firebaseauthentication.ui.presentation.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::SignupViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SplashViewModel)
}