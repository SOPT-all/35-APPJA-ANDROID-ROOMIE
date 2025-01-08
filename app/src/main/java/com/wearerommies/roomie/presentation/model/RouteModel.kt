package com.wearerommies.roomie.presentation.model

import kotlinx.serialization.Serializable

sealed interface Route

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Map : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}