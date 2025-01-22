package com.wearerommies.roomie.presentation.ui.map.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.presentation.navigator.route.FilterType
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.ui.map.MapRoute
import kotlin.reflect.typeOf

fun NavController.navigateToMap(filter: FilterEntity, navOptions: NavOptions? = null) {
    navigate(
        route = MainTabRoute.Map(filter),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mapNavGraph(
    paddingValues: PaddingValues,
    navigateToSearch: () -> Unit,
    navigateToFilter: () -> Unit
) {
    composable<MainTabRoute.Map>(
        typeMap = mapOf(typeOf<FilterEntity>() to FilterType)
    ) {backStackEntry ->
        MapRoute(
            paddingValues = paddingValues,
            navigateToSearch = navigateToSearch,
            navigateToFilter = navigateToFilter,
            filterEntity = backStackEntry.toRoute<MainTabRoute.Map>().filter
        )
    }
}
