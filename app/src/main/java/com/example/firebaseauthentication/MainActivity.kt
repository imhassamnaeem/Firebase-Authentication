package com.example.firebaseauthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firebaseauthentication.ui.navigation.AppNavigator
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAuthenticationTheme {
                AppNavigator()
            }
        }
    }
}