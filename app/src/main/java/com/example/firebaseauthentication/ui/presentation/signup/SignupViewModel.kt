package com.example.firebaseauthentication.ui.presentation.signup

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

class SignupViewModel : ViewModel() {
    var uiState by mutableStateOf(SignupUiStates())
        private set
    private val _event = MutableSharedFlow<SignUpEvent>()
    val event: SharedFlow<SignUpEvent> = _event.asSharedFlow()

    fun onIntent(intent: SignUpIntent) {
        when (intent) {
            is SignUpIntent.EmailChanged -> {
                uiState = uiState.copy(
                    email = intent.email,
                    emailError = null
                )
            }

            is SignUpIntent.PasswordChanged -> {
                uiState = uiState.copy(
                    password = intent.password,
                    passwordError = null
                )
            }

            is SignUpIntent.ConfirmPasswordChanged -> {
                uiState = uiState.copy(
                    confirmPassword = intent.confirmPassword,
                    confirmPasswordError = null
                )
            }

            SignUpIntent.TogglePasswordVisibility -> {
                uiState = uiState.copy(
                    isPasswordVisible = !uiState.isPasswordVisible,
                    passwordError = null
                )
            }

            SignUpIntent.ToggleConfirmPasswordVisibility -> {
                uiState = uiState.copy(
                    isConfirmPasswordVisible = !uiState.isConfirmPasswordVisible,
                    confirmPasswordError = null
                )
            }

            SignUpIntent.LoginClicked -> {
                emit(SignUpEvent.OnNavigateToLogin)
            }

            SignUpIntent.SignupClicked -> signUp()
        }
    }

    fun signUp() {
        val email = uiState.email.trim()
        val password = uiState.password
        val confirmPassword = uiState.confirmPassword

        val emailError = AuthValidation.validateEmail(email)
        val passwordError = AuthValidation.validatePassword(password)
        val confirmPasswordError = AuthValidation.validateConfirmPassword(password, confirmPassword)

        uiState = uiState.copy(
            emailError = emailError,
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError
        )

        if (emailError == null && passwordError == null && confirmPasswordError == null) {
            emit(SignUpEvent.OnNavigateToHome)
        }
    }

    fun emit(event: SignUpEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}

data class SignupUiStates(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
)

sealed interface SignUpIntent {
    data class EmailChanged(val email: String) : SignUpIntent
    data class PasswordChanged(val password: String) : SignUpIntent
    data class ConfirmPasswordChanged(val confirmPassword: String) : SignUpIntent
    data object TogglePasswordVisibility : SignUpIntent
    data object ToggleConfirmPasswordVisibility : SignUpIntent
    data object LoginClicked : SignUpIntent
    data object SignupClicked : SignUpIntent
}

sealed interface SignUpEvent {
    data object OnNavigateToHome : SignUpEvent
    data object OnNavigateToLogin : SignUpEvent
}