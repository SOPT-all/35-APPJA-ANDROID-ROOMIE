package com.wearerommies.roomie.presentation.ui.mood.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.mood.MoodRoute

fun NavController.navigateToMood(moodTag: String, navOptions: NavOptions? = null) {
    navigate(
        route = Route.Mood(
            moodTag = moodTag
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.moodNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Route.Mood> { backStackEntry ->
        val moodTag = backStackEntry.toRoute<Route.Mood>().moodTag
        MoodRoute(
            paddingValues = paddingValues,
            moodTag = moodTag,
            navigateUp = navigateUp
        )
    }
}