package com.wearerommies.roomie.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route

fun NavController.navigateToBookmark(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Bookmark,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.bookmarkNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Bookmark> {
//        BookmarkRoute(
//            paddingValues = paddingValues,
//            navigateUp = navigateUp
//        )
    }
}