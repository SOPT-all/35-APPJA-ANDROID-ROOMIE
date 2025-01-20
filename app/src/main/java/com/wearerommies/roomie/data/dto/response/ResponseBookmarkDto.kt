package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.BookmarkEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBookmarkDto(
    @SerialName("isBookmark")
    val isBookmark: Boolean
) {
    fun toEntity() = BookmarkEntity(
        isBookmark = isBookmark
    )
}