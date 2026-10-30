package com.example.firebaseauthentication.ui.presentation.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseauthentication.shared.validation.AuthValidation
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    private val _event = MutableSharedFlow<LoginEvent>()
    val event: SharedFlow<LoginEvent> = _event.asSharedFlow()

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EmailChanged -> {
                uiState = uiState.copy(
                    email = intent.email,
                    emailError = null
                )
            }

            is LoginIntent.PasswordChanged -> {
                uiState = uiState.copy(
                    password = intent.password,
                    passwordError = null
                )
            }

            LoginIntent.TogglePasswordVisibility -> {
                uiState = uiState.copy(
                    isPasswordVisible = !uiState.isPasswordVisible
                )
            }

            LoginIntent.LoginClicked -> login()

            LoginIntent.SignUpClicked -> {
                emit(LoginEvent.NavigateToSignup)
            }
        }
    }

    fun login() {
        val email = uiState.email.trim()

        val password = uiState.password

        val emailError = AuthValidation.validateEmail(email)

        val passwordError = AuthValidation.validatePassword(password)

        uiState = uiState.copy(
            emailError = emailError,
            passwordError = passwordError
        )

        if (emailError == null && passwordError == null) {
            emit(LoginEvent.NavigateToHome)
        }
    }

    private fun emit(event: LoginEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}

sealed interface LoginIntent {
    data class EmailChanged(val email: String) : LoginIntent
    data class PasswordChanged(val password: String) : LoginIntent
    data object TogglePasswordVisibility : LoginIntent
    object LoginClicked : LoginIntent
    data object SignUpClicked : LoginIntent
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val passwordError: String? = null
)

sealed interface LoginEvent {
    data object NavigateToSignup : LoginEvent
    data object NavigateToHome : LoginEvent
}