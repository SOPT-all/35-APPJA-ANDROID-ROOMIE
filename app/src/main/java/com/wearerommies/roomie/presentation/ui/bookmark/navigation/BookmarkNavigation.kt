package com.wearerommies.roomie.presentation.ui.bookmark.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.bookmark.BookMarkRoute

fun NavController.navigateToBookmark(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Bookmark,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.bookmarkNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToDetail: (Long) -> Unit
) {
    composable<Route.Bookmark> {
        BookMarkRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateToDetail = navigateToDetail
        )
    }
}