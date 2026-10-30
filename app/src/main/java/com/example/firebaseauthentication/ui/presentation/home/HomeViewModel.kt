package com.example.firebaseauthentication.ui.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    private val _event = MutableSharedFlow<HomeEvent>()
    val event: SharedFlow<HomeEvent> = _event.asSharedFlow()

    fun onIntent(intent: HomeIntent){
        when(intent){
            HomeIntent.LogoutClicked->{
                emit(HomeEvent.OnNavigateToLogin)
            }
        }
    }

    fun emit(event: HomeEvent){
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}

data class HomeUiState(
    val welcomeMessage: String = "Welcome to Home"
)

sealed interface HomeIntent {
    data object LogoutClicked : HomeIntent
}

sealed interface HomeEvent {
    data object OnNavigateToLogin : HomeEvent
}