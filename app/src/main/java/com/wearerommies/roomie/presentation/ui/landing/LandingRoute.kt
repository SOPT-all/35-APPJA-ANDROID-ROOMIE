package com.wearerommies.roomie.presentation.ui.landing

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wearerommies.roomie.presentation.core.component.RoomieWebView
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme

object WebViewUrl {
    const val LANDING = "https://roomieofficial.framer.website/"
}

@Composable
fun LandingRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {

    LandingScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
    )
}

@Composable
fun LandingScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    RoomieWebView(url = WebViewUrl.LANDING, onClose = navigateUp)
}

@Preview
@Composable
fun LandingScreenPreview() {
    RoomieAndroidTheme {
        LandingScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
        )
    }
}