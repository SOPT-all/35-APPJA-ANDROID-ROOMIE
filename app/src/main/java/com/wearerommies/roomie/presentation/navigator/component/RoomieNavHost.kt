package com.wearerommies.roomie.presentation.navigator.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.wearerommies.roomie.presentation.navigator.MainNavigator
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.presentation.ui.bookmark.navigation.bookmarkNavGraph
import com.wearerommies.roomie.presentation.ui.detail.navigation.detailNavGraph
import com.wearerommies.roomie.presentation.ui.filter.navigation.filterNavGraph
import com.wearerommies.roomie.presentation.ui.home.navigation.homeNavGraph
import com.wearerommies.roomie.presentation.ui.map.navigation.mapNavGraph
import com.wearerommies.roomie.presentation.ui.mood.navigation.moodNavGraph
import com.wearerommies.roomie.presentation.ui.mypage.navigation.myNavGraph
import com.wearerommies.roomie.presentation.ui.search.navigation.searchNavGraph
import com.wearerommies.roomie.presentation.ui.splash.navigation.splashNavGraph
import com.wearerommies.roomie.presentation.ui.tour.navigation.tourNavGraph

@Composable
fun RoomieNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination
    ) {
        splashNavGraph()
        homeNavGraph(
            paddingValues = padding,
            navigateToBookmark = navigator::navigateToBookmark,
            navigateToMood = navigator::navigateToMood,
            navigateToMap = { navigator.navigate(tab = MainTabType.MAP) },
            navigateToDetail = navigator::navigateToDetail
        )
        mapNavGraph(
            paddingValues = padding,
            navigateToSearch = navigator::navigateToSearch,
            navigateToFilter = navigator::navigateToFilter
        )
        myNavGraph(
            paddingValues = padding,
            navigateToBookmark = navigator::navigateToBookmark
        )
        searchNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
        moodNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
        bookmarkNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
        filterNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
        detailNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
        tourNavGraph(
            paddingValues = padding,
            navigateUp = navigator::popBackStackIfNotHome
        )
    }
}
