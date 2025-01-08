package com.wearerommies.roomie.presentation.ui.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.model.MainTabRoute

fun NavController.navigateMap(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Map,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mapNavGraph() {
    composable<MainTabRoute.Map> {
        MapRoute(
            paddingValues = PaddingValues(),
            navigateUp = {}
        )
    }

}