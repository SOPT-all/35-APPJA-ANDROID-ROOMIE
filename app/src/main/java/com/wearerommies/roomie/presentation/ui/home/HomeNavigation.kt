package com.wearerommies.roomie.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.ui.home.HomeRoute.ROUTE

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(
        route = ROUTE,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph() {
    composable(
        route = ROUTE,
    ) {
        HomeRoute(
            paddingValues = PaddingValues(),
            navigateUp = {}
        )
    }

}

object HomeRoute {
    const val ROUTE = "home"
}
