package com.wearerommies.roomie.presentation.ui.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.search.SearchRoute

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Search,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.searchNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Search> {
        SearchRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp
        )
    }
}
