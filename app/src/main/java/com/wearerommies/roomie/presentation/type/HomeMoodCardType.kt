package com.wearerommies.roomie.presentation.type

import androidx.annotation.StringRes
import com.wearerommies.roomie.R

enum class HomeMoodCardType(
    @StringRes val moodTag: Int,
) {
    CALM(
        moodTag = R.string.mood_tag_calm
    ),
    ACTIVE(
        moodTag = R.string.mood_tag_active
    ),
    CLEAN(
        moodTag = R.string.mood_tag_clean
    )
}