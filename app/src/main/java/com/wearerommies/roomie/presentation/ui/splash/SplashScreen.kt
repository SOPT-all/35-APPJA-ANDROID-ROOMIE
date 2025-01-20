package com.wearerommies.roomie.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .background(RoomieTheme.colors.primary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height((LocalConfiguration.current.screenHeightDp * 0.435).dp))

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash_character_white),
            contentDescription = null,
            modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.183).dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash_logo_white),
            contentDescription = null,
            modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.197).dp)
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
