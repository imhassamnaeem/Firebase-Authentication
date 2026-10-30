package com.example.firebaseauthentication.shared.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    color:Color = Color.Unspecified
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize=fontSize,
        fontWeight=fontWeight,
        color = color
    )
}