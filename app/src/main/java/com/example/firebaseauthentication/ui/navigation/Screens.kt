package com.example.firebaseauthentication.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens : NavKey {
    @Serializable
    data object Splash : Screens()
    @Serializable
    data object Login : Screens()
    @Serializable
    data object Signup : Screens()
    @Serializable
    data object Home : Screens()
}