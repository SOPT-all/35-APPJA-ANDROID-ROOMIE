package com.wearerommies.roomie.presentation.ui.tour.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.tour.TourFirstStepRoute
import com.wearerommies.roomie.presentation.ui.tour.TourSecondStepRoute
import com.wearerommies.roomie.presentation.ui.tour.TourViewModel

fun NavController.navigateToTourFirstStep(houseId: Long, roomId: Long, houseName: String, roomName: String, navOptions: NavOptions? = null) {
    navigate(
        route = Route.TourFirstStep(
            houseId = houseId,
            roomId = roomId,
            houseName = houseName,
            roomName = roomName
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.tourNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    // navigateSecondStep: () -> Unit
) {
    composable<Route.TourFirstStep> { backStackEntry ->

        val houseId = backStackEntry.toRoute<Route.TourFirstStep>().houseId
        val roomId = backStackEntry.toRoute<Route.TourFirstStep>().roomId
        val houseName = backStackEntry.toRoute<Route.TourFirstStep>().houseName
        val roomName = backStackEntry.toRoute<Route.TourFirstStep>().roomName

        TourFirstStepRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            houseId = houseId,
            roomId = roomId,
            houseName = houseName,
            roomName = roomName
            // navigateTwoStep = navigateSecondStep
        )
    }
}