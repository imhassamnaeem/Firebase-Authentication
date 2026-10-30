package com.example.firebaseauthentication.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebaseauthentication.shared.component.AppButton
import com.example.firebaseauthentication.shared.component.AppIconButton
import com.example.firebaseauthentication.shared.component.AppOutlinedTextField
import com.example.firebaseauthentication.shared.component.AppText
import com.example.firebaseauthentication.shared.component.AppTextButton
import com.example.firebaseauthentication.shared.component.AuthHeader
import com.example.firebaseauthentication.shared.component.Spacer
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme

@Composable
fun LoginScreen(
    state: LoginUiState = LoginUiState(),
    onIntent: (LoginIntent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthHeader(
            title = "Welcome Back",
            subtitle = "Login to your account"
        )

        Spacer(height = 36.dp)

        AppOutlinedTextField(
            value = state.email,
            onValueChange = { onIntent(LoginIntent.EmailChanged(it)) },
            label = "Enter Email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = state.emailError != null,
        )

        Spacer(height = 8.dp)

        AppOutlinedTextField(
            value = state.password,
            onValueChange = { onIntent(LoginIntent.PasswordChanged(it)) },
            label = "Enter Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = state.passwordError != null,
            visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                AppIconButton(
                    imageVector = if (state.isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    onClick = {
                        onIntent(LoginIntent.TogglePasswordVisibility)
                    },
                    contentDescription = "Toggle Password Visibility"
                )
            }
        )

        Spacer(height = 16.dp)

        AppButton(
            text = "Login",
            onClick = {
                onIntent(LoginIntent.LoginClicked)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(text = "Don't have an account? ")

            AppTextButton(
                text = "SignUp",
                onClick = {
                    onIntent(LoginIntent.SignUpClicked)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    FirebaseAuthenticationTheme {
        LoginScreen()
    }
}