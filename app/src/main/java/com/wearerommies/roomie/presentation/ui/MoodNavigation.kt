package com.wearerommies.roomie.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wearerommies.roomie.presentation.navigator.route.Route

fun NavController.navigateToMood(navOptions: NavOptions? = null) {
    navigate(
        route = Route.Mood,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.moodNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Mood> {
//        MoodRoute(
//            paddingValues = paddingValues,
//            navigateUp = navigateUp
//        )
    }
}