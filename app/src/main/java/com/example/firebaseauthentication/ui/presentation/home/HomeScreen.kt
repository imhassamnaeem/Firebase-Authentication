package com.example.firebaseauthentication.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebaseauthentication.shared.component.AppButton
import com.example.firebaseauthentication.shared.component.AuthHeader
import com.example.firebaseauthentication.shared.component.Spacer
import com.example.firebaseauthentication.ui.theme.FirebaseAuthenticationTheme

@Composable
fun HomeScreen(
    state: HomeUiState = HomeUiState(),
    onIntent: (HomeIntent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AuthHeader(
            title = "Welcome!",
            subtitle = "You are successfully logged in.",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(height = 32.dp)

        AppButton(
            text = "Logout",
            onClick = {
                onIntent(HomeIntent.LogoutClicked)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FirebaseAuthenticationTheme() {
        HomeScreen()
    }
}