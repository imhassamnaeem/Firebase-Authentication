package com.example.firebaseauthentication.ui.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _event = MutableSharedFlow<SplashEvent>()
    val event: SharedFlow<SplashEvent> = _event.asSharedFlow()

    init {
        checkSplash()
    }

    fun checkSplash(){
        viewModelScope.launch {
            delay(2000)
            emit(SplashEvent.NavigateToLogin)
        }
    }

    private fun emit(event: SplashEvent){
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}

sealed interface SplashEvent {
    data object NavigateToLogin : SplashEvent
    data object NavigateToHome : SplashEvent
}