package com.wearerommies.roomie.presentation.ui.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.ui.map.MapRoute.ROUTE

fun NavController.navigateMap(navOptions: NavOptions) {
    navigate(
        route = ROUTE,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mapNavGraph() {
    composable(
        route = ROUTE,
    ) {
        MapRoute(
            paddingValues = PaddingValues(),
            navigateUp = {}
        )
    }

}

object MapRoute {
    const val ROUTE = "map"
}