package com.wearerommies.roomie.presentation.ui.tour.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route

fun NavController.navigateToTour(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Tour,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.tourNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Tour> {
//        TourRoute(
//            paddingValues = paddingValues,
//            navigateUp = navigateUp
//        )
    }
}