package com.example.firebaseauthentication.shared.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


@Composable
fun ColumnScope.Spacer(
height: Dp,
modifier: Modifier = Modifier
) {
Spacer(
    modifier = modifier.height(height)
)
}