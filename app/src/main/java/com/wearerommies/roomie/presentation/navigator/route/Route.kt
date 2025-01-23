package com.wearerommies.roomie.presentation.navigator.route

import android.os.Bundle
import androidx.navigation.NavType
import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.SearchResultEntity
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
    data object Tour : Route

    @Serializable
    data class WebView(
        val webViewUrl: String
    ) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data class Map(
        val filter: FilterEntity,
        val result: SearchResultEntity
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


val ResultType = object : NavType<SearchResultEntity>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): SearchResultEntity? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): SearchResultEntity {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: SearchResultEntity) {
        bundle.putString(key, Json.encodeToString(SearchResultEntity.serializer(), value))
    }

    override fun serializeAsValue(value: SearchResultEntity): String {
        return Json.encodeToString(SearchResultEntity.serializer(), value)
    }
}

