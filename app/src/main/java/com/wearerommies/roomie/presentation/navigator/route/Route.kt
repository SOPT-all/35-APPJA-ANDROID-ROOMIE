package com.wearerommies.roomie.presentation.navigator.route

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Search : Route

    @Serializable
    data object Mood : Route

    @Serializable
    data object Bookmark : Route

    @Serializable
    data object Filter : Route

    @Serializable
    data object Detail : Route

    @Serializable
    data object DetailAllImage : Route

    @Serializable
    data object DetailRoomsImage : Route

    @Serializable
    data object Tour : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Map : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}
