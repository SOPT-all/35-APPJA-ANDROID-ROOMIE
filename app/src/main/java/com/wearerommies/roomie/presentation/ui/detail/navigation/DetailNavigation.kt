package com.wearerommies.roomie.presentation.ui.detail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.detail.DetailRoute
import com.wearerommies.roomie.presentation.ui.detail.room.DetailRoomRoute

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

fun NavController.navigateToDetailRoom(houseId: Long, roomId: Long, title: String, navOptions: NavOptions? = null) {
    navigate(
        route = Route.DetailRoom(
            houseId = houseId,
            roomId = roomId,
            title = title
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.detailNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateDetailRoom: (Long, Long, String) -> Unit
) {
    composable<Route.Detail> { backStackEntry ->
        val houseId = backStackEntry.toRoute<Route.Detail>().houseId
        DetailRoute(
            paddingValues = paddingValues,
            houseId = houseId,
            navigateUp = navigateUp,
            navigateDetailRoom = navigateDetailRoom
        )
    }
    /*composable<Route.DetailHouse> { backStackEntry ->
        val houseId = backStackEntry.toRoute<Route.DetailRoom>().houseId
        DetailHouseRoute(
            paddingValues = paddingValues,
            houseId = houseId,
            navigateUp = navigateUp
        )
    }*/

    composable<Route.DetailRoom> { backStackEntry ->
        val houseId = backStackEntry.toRoute<Route.DetailRoom>().houseId
        val roomId = backStackEntry.toRoute<Route.DetailRoom>().roomId
        val title = backStackEntry.toRoute<Route.DetailRoom>().title
            DetailRoomRoute(
                paddingValues = paddingValues,
                houseId = houseId,
                roomId = roomId,
                title = title,
                navigateUp = navigateUp,
            )
    }
}
