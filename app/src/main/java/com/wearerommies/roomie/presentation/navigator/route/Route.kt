package com.wearerommies.roomie.presentation.navigator.route

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object Search : Route

    @Serializable
    data class Mood(
        val moodTag: String
    ) : Route

    @Serializable
    data object Bookmark : Route

    @Serializable
    data object Filter : Route

    @Serializable
    data class Detail(
        val houseId: Long
    ) : Route

    @Serializable
    data object DetailHouse : Route

    @Serializable
    data object DetailRoom : Route

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
