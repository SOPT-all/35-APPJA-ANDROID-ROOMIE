package com.wearerommies.roomie.presentation.navigator

import androidx.compose.runtime.staticCompositionLocalOf

val LocalSnackBarTrigger = staticCompositionLocalOf<String> {
    error("No SnackBar provided")
}