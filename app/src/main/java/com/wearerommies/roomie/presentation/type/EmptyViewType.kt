package com.wearerommies.roomie.presentation.type

import androidx.annotation.StringRes
import com.wearerommies.roomie.R

enum class EmptyViewType(
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    SEARCH(
        title = R.string.no_search_result,
        description = R.string.check_again
    ),
    LIST(
        title = R.string.location_no_room,
        description = R.string.search_other_place
    )
}
