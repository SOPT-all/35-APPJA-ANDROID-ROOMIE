package com.wearerommies.roomie.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.model.MainTabRoute

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
