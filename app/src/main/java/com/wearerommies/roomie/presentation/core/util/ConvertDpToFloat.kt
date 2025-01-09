package com.wearerommies.roomie.presentation.core.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun convertDpToFloat(dpValue: Dp): Float {
    val density = LocalDensity.current.density
    return dpValue.value * density
}