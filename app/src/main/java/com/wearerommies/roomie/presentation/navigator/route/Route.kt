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
    data class DetailHouse(
        val houseId: Long,
        val title: String
    ) : Route

    @Serializable
    data class DetailRoom(
        val houseId: Long,
        val roomId: Long,
        val title: String
    ) : Route

    @Serializable
    data class TourFirstStep(
        val houseId: Long,
        val roomId: Long,
        val houseName: String,
        val roomName: String
    ) : Route

    @Serializable
    data object TourSecondStep : Route

    @Serializable
    data object TourThirdStep : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Map : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}
