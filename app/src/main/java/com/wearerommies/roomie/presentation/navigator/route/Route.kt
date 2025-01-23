package com.wearerommies.roomie.presentation.navigator.route

import android.os.Bundle
import androidx.navigation.NavType
import com.wearerommies.roomie.domain.entity.TourEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

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
        val tourApply: TourEntity,
        val houseName: String,
        val roomName: String
    ) : Route {
        companion object {
            val typeMap = mapOf(
                typeOf<TourEntity>() to tourApplyType
            )
        }
    }

    @Serializable
    data class TourSecondStep(
        val tourApply: TourEntity
    ) : Route

    @Serializable
    data class TourThirdStep(
        val tourApply: TourEntity
    ) : Route
}

val tourApplyType = object: NavType<TourEntity>(isNullableAllowed = false){
    override fun get(bundle: Bundle, key: String): TourEntity? {
        return bundle.getString(key)?.let {
            Json.decodeFromString(it)
        }
    }

    override fun parseValue(value: String): TourEntity {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: TourEntity) {
        bundle.putString(key, Json.encodeToString(TourEntity.serializer(), value))
    }

    override fun serializeAsValue(value: TourEntity): String {
        return Json.encodeToString(TourEntity.serializer(), value)
    }
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Map : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}
