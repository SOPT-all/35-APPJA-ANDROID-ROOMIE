package com.wearerommies.roomie.presentation.ui.map.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.ui.map.MapRoute

fun NavController.navigateToMap(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Map,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mapNavGraph(
    navigateToSearch: () -> Unit
) {
    composable<MainTabRoute.Map> {
        MapRoute(
            paddingValues = PaddingValues(),
            navigateUp = {},
            navigateToSearch = { navigateToSearch() }
        )
    }
}
