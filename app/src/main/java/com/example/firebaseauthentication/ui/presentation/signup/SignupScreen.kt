package com.example.firebaseauthentication.ui.presentation.signup

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
import com.example.firebaseauthentication.shared.validation.AuthValidation
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme

@Composable
fun SignUpScreen(
    states: SignupUiStates = SignupUiStates(),
    onIntent: (SignUpIntent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AuthHeader(
            title = " Create Account ",
            subtitle = " Signup to get started",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(36.dp)

        AppOutlinedTextField(
            value = states.email,
            onValueChange = { onIntent(SignUpIntent.EmailChanged(it)) },
            label = "Enter Email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = states.emailError != null,
        )

        Spacer(height = 8.dp)

        AppOutlinedTextField(
            value = states.password,
            onValueChange = { onIntent(SignUpIntent.PasswordChanged(it)) },
            label = "Enter Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = states.passwordError != null,
            visualTransformation = if (states.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                AppIconButton(
                    imageVector = if (states.isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    onClick = {
                        onIntent(SignUpIntent.TogglePasswordVisibility)
                    },
                    contentDescription = "Toggle Password Visibility"
                )
            }
        )

        Spacer(8.dp)

        AppOutlinedTextField(
            value = states.confirmPassword,
            onValueChange = { onIntent(SignUpIntent.ConfirmPasswordChanged(it)) },
            label = "Confirm Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = states.confirmPasswordError != null,
            visualTransformation = if (states.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                AppIconButton(
                    imageVector = if (states.isConfirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    onClick = {
                        onIntent(SignUpIntent.ToggleConfirmPasswordVisibility)
                    },
                    contentDescription = "Toggle Confirm Password Visibility"
                )
            }
        )

        Spacer(height = 16.dp)

        AppButton(
            text = "Signup",
            onClick = {
                onIntent(SignUpIntent.SignupClicked)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            AppText(text = "Already have an account? ")

            AppTextButton(
                text = "Login",
                onClick = {
                    onIntent(SignUpIntent.LoginClicked)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    FirebaseAuthenticationTheme()
    {
        SignUpScreen()
    }
}