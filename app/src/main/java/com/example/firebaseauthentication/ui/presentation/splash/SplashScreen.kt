package com.example.firebaseauthentication.ui.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.shared.component.AppImage
import com.example.firebaseauthentication.shared.component.AppText
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppImage(
            imageResource = R.drawable.splash_icon,
            contentDescription = "Splash logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    FirebaseAuthenticationTheme()
    {
        SplashScreen()
    }
}