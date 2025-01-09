package com.wearerommies.roomie.presentation.navigator.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.wearerommies.roomie.presentation.navigator.MainNavigator
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.ui.home.homeNavGraph
import com.wearerommies.roomie.presentation.ui.map.mapNavGraph
import com.wearerommies.roomie.presentation.ui.mypage.myNavGraph

@Composable
fun RoomieNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = MainTabRoute.Home
    ) {
        homeNavGraph()
        mapNavGraph()
        myNavGraph()
    }
}