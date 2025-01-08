package com.wearerommies.roomie.presentation.ui.mypage

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.ui.mypage.MyRoute.ROUTE

fun NavController.navigateMy(navOptions: NavOptions) {
    navigate(
        route = ROUTE,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.myNavGraph() {
    composable(
        route = ROUTE,
    ) {
        MyRoute(
            paddingValues = PaddingValues(),
            navigateUp = {}
        )
    }

}

object MyRoute {
    const val ROUTE = "my"
}