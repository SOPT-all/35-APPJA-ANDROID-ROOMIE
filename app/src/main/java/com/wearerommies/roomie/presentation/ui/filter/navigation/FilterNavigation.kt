package com.wearerommies.roomie.presentation.ui.filter.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.filter.FilterRoute

fun NavController.navigateToFilter(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Filter,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.filterNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Route.Filter> {
        FilterRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp
        )
    }
}
