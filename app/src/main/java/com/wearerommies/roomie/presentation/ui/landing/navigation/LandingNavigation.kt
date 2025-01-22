package com.wearerommies.roomie.presentation.ui.landing.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.landing.LandingRoute

fun NavController.navigateToLanding(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Landing,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.landingNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Route.Landing> {
        LandingRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
        )
    }
}
