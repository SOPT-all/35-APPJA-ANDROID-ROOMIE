package com.wearerommies.roomie.presentation.navigator.route

import android.os.Bundle
import androidx.navigation.NavType
import com.wearerommies.roomie.domain.entity.FilterEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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
    data class Map(
        val filter: FilterEntity
    ) : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}

val FilterType = object : NavType<FilterEntity>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): FilterEntity? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): FilterEntity {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: FilterEntity) {
        bundle.putString(key, Json.encodeToString(FilterEntity.serializer(), value))
    }

    override fun serializeAsValue(value: FilterEntity): String {
        return Json.encodeToString(FilterEntity.serializer(), value)
    }
}
