package com.wearerommies.roomie.presentation.type

import androidx.annotation.StringRes
import com.wearerommies.roomie.R

enum class MyType (
    @StringRes val title: Int,
    ){
    SERVICE(
        title = R.string.service_introduction
    ),
    UPDATE(
        title = R.string.recent_updates
    ),
    POLICY(
        title = R.string.policy_and_terms
    ),
}