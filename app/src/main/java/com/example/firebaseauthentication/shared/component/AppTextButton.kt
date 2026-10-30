package com.example.firebaseauthentication.shared.component

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.textButtonColors()
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors
    ) {
        AppText(text = text,
            color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(showBackground = true)
@Composable
fun AppTextButtonPreview(){
    AppTextButton(text = "Signup",
        onClick = {},
        modifier = Modifier)
}