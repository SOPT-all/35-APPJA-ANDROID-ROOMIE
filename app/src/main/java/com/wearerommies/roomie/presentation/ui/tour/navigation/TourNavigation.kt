package com.wearerommies.roomie.presentation.ui.tour.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.tour.first.TourFirstStepRoute
import com.wearerommies.roomie.presentation.ui.tour.second.TourSecondStepRoute
import com.wearerommies.roomie.presentation.ui.tour.third.TourThirdStepRoute

fun NavController.navigateToTourFirstStep(tourApply: TourEntity, houseName: String, roomName: String, navOptions: NavOptions? = null) {
    navigate(
        route = Route.TourFirstStep(
            tourApply = tourApply,
            houseName = houseName,
            roomName = roomName
        ),
        navOptions = navOptions
    )
}

fun NavController.navigateToTourSecondStep(tourApply: TourEntity, navOptions: NavOptions? = null) {
    navigate(
        route = Route.TourSecondStep(
            tourApply = tourApply
        ),
        navOptions = navOptions
    )
}

fun NavController.navigateToTourThirdStep(tourApply: TourEntity, navOptions: NavOptions? = null) {
    navigate(
        route = Route.TourThirdStep(
            tourApply = tourApply
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.tourNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateSecondStep: (TourEntity) -> Unit,
    navigateThirdStep: (TourEntity) -> Unit
) {

    composable<Route.TourFirstStep> (
        typeMap = Route.TourFirstStep.typeMap
    ){ backStackEntry ->
        TourFirstStepRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            tourApply = backStackEntry.toRoute<Route.TourFirstStep>().tourApply,
            houseName = backStackEntry.toRoute<Route.TourFirstStep>().houseName,
            roomName = backStackEntry.toRoute<Route.TourFirstStep>().roomName,
            navigateTwoStep = navigateSecondStep
        )
    }

    composable<Route.TourSecondStep>(
        typeMap = Route.TourFirstStep.typeMap
    ) { backStackEntry ->

        TourSecondStepRoute(
            paddingValues = paddingValues,
            tourApply = backStackEntry.toRoute<Route.TourSecondStep>().tourApply,
            navigateUp = navigateUp,
            navigateThirdStep = navigateThirdStep,
        )

    }

    composable<Route.TourThirdStep>(
        typeMap = Route.TourFirstStep.typeMap
    ) { backStackEntry ->

        TourThirdStepRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            tourApply = backStackEntry.toRoute<Route.TourThirdStep>().tourApply,
            navigateCompletedStep = navigateUp,
        )

    }
}

