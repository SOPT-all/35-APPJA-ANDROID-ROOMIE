package com.wearerommies.roomie.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.wearerommies.roomie.R

enum class HomeMoodCardType(
    @StringRes val moodTag: Int,
    @DrawableRes val moodDrawableResId: Int
) {
    CALM(
        moodTag = R.string.mood_tag_calm,
        moodDrawableResId = R.drawable.img_home_calm
    ),
    ACTIVE(
        moodTag = R.string.mood_tag_active,
        moodDrawableResId = R.drawable.img_home_active
    ),
    CLEAN(
        moodTag = R.string.mood_tag_clean,
        moodDrawableResId = R.drawable.img_home_clean
    )
}