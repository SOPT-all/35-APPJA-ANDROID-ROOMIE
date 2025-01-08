package com.wearerommies.roomie.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalRommieColors = staticCompositionLocalOf<RommieColors> {
    error("No RommieColors provided")
}

private val LocalRommieTypography = staticCompositionLocalOf<RommieTypography> {
    error("No RommieTypography provided")
}

object RommieTheme {
    val colors: RommieColors
        @Composable
        @ReadOnlyComposable
        get() = LocalRommieColors.current

    val typography: RommieTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalRommieTypography.current
}

@Composable
fun ProvideRommieColorsAndTypography(
    colors: RommieColors,
    typography: RommieTypography,
    content: @Composable () -> Unit
) {
    val provideColors = remember { colors.copy() }
    provideColors.update(colors)

    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)

    CompositionLocalProvider(
        LocalRommieColors provides provideColors,
        LocalRommieTypography provides provideTypography,
        content = content
    )
}

@Composable
fun RoomieAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = rommieColors()
    val typography = rommieTypography()

    ProvideRommieColorsAndTypography(colors, typography) {
        MaterialTheme(content = content)
    }
}
