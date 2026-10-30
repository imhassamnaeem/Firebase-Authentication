package com.example.firebaseauthentication.shared.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebaseauthentication.R

@Composable
fun AppImage(
    @DrawableRes imageResource: Int,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = colorFilter,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppImagePreview() {
    AppImage(
        imageResource = R.drawable.splash_icon,
        modifier = Modifier.padding(4.dp)
    )
}