package com.wearerommies.roomie.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.ui.home.HomeRoute

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Home,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph() {
    composable<MainTabRoute.Home>{
        HomeRoute(
            paddingValues = PaddingValues(),
            navigateUp = {}
        )
    }

}
