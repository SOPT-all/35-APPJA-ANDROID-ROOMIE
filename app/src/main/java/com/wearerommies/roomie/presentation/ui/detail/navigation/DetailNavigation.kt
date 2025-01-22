package com.wearerommies.roomie.presentation.ui.detail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.detail.DetailRoute

fun NavController.navigateToDetail(houseId: Long, navOptions: NavOptions? = null) {
    navigate(
        route = Route.Detail(
            houseId = houseId
        ),
        navOptions = navOptions
    )
}

fun NavController.navigateToDetailHouse(navOptions: NavOptions? = null) {
    navigate(
        route = Route.DetailHouse,
        navOptions = navOptions
    )
}

fun NavController.navigateToDetailRoom(navOptions: NavOptions? = null) {
    navigate(
        route = Route.DetailRoom,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.detailNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Detail> { backStackEntry ->
        val houseId = backStackEntry.toRoute<Route.Detail>().houseId
        DetailRoute(
            paddingValues = paddingValues,
            houseId = houseId,
            navigateUp = navigateUp,
        )
    }
    composable<Route.DetailHouse> {
//        DetailHouseRoute(
//            paddingValues = paddingValues,
//            navigateUp = navigateUp
//        )
    }
    composable<Route.DetailRoom> {
//        DetailRoomsImageRoute(
//            paddingValues = paddingValues,
//            navigateUp = navigateUp
//        )
    }
}
