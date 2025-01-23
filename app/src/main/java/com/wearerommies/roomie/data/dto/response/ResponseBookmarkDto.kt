package com.wearerommies.roomie.data.dto.response


import com.wearerommies.roomie.domain.entity.BookmarkEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBookmarkDto(
    @SerialName("isPinned")
    val isPinned: Boolean
) {
    fun toEntity() = BookmarkEntity(
        isPinned = isPinned
    )
}