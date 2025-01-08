package com.wearerommies.roomie.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalRoomieColors = staticCompositionLocalOf<RoomieColors> {
    error("No RoomieColors provided")
}

private val LocalRoomieTypography = staticCompositionLocalOf<RoomieTypography> {
    error("No RoomieTypography provided")
}

object RoomieTheme {
    val colors: RoomieColors
        @Composable
        @ReadOnlyComposable
        get() = LocalRoomieColors.current

    val typography: RoomieTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalRoomieTypography.current
}

@Composable
fun ProvideRoomieColorsAndTypography(
    colors: RoomieColors,
    typography: RoomieTypography,
    content: @Composable () -> Unit
) {
    val provideColors = remember { colors.copy() }
    provideColors.update(colors)

    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)

    CompositionLocalProvider(
        LocalRoomieColors provides provideColors,
        LocalRoomieTypography provides provideTypography,
        content = content
    )
}

@Composable
fun RoomieAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = roomieColors()
    val typography = roomieTypography()

    ProvideRoomieColorsAndTypography(colors, typography) {
        MaterialTheme(content = content)
    }
}
