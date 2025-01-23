package com.wearerommies.roomie.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.presentation.ui.bookmark.navigation.navigateToBookmark
import com.wearerommies.roomie.presentation.ui.filter.navigation.navigateToFilter
import com.wearerommies.roomie.presentation.ui.home.navigation.navigateToHome
import com.wearerommies.roomie.presentation.ui.map.navigation.navigateToMap
import com.wearerommies.roomie.presentation.ui.mood.navigation.navigateToMood
import com.wearerommies.roomie.presentation.ui.mypage.navigation.navigateToMy
import com.wearerommies.roomie.presentation.ui.detail.navigation.navigateToDetail
import com.wearerommies.roomie.presentation.ui.detail.navigation.navigateToDetailHouse
import com.wearerommies.roomie.presentation.ui.detail.navigation.navigateToDetailRoom
import com.wearerommies.roomie.presentation.ui.search.navigation.navigateToSearch
import com.wearerommies.roomie.presentation.ui.tour.navigation.navigateToTourFirstStep
import com.wearerommies.roomie.presentation.ui.tour.navigation.navigateToTourSecondStep
import com.wearerommies.roomie.presentation.ui.tour.navigation.navigateToTourThirdStep

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTabRoute.Home

    val currentTab: MainTabType?
        @Composable get() = MainTabType.find { tab ->
            currentDestination?.route == tab::class.qualifiedName
        }

    fun navigate(tab: MainTabType) {
        val navOptions = navOptions {
            popUpTo<MainTabRoute.Home> {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTabType.HOME -> navController.navigateToHome(navOptions)
            MainTabType.MAP -> navController.navigateToMap(navOptions)
            MainTabType.MY -> navController.navigateToMy(navOptions)
        }
    }

    private fun navigateUp() {
        navController.navigateUp()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            navigateUp()
        }
    }

    fun navigateToSearch() {
        navController.navigateToSearch()
    }

    fun navigateToMood(moodTag: String) {
        navController.navigateToMood(moodTag = moodTag)
    }

    fun navigateToBookmark() {
        navController.navigateToBookmark()
    }

    fun navigateToFilter() {
        navController.navigateToFilter()
    }

    fun navigateToDetail(houseId: Long) {
        navController.navigateToDetail(houseId = houseId)
    }

    fun navigateToDetailHouse(houseId: Long, title: String) {
        navController.navigateToDetailHouse(
            houseId = houseId,
            title = title
        )
    }

    fun navigateToDetailRoom(houseId: Long, roomId: Long, title: String) {
        navController.navigateToDetailRoom(
            houseId = houseId,
            roomId = roomId,
            title = title
        )
    }

    fun navigateToTourFirstStep(tourApply: TourEntity, houseName: String, roomName: String) {
        navController.navigateToTourFirstStep(tourApply, houseName, roomName)
    }

    fun navigateToTourSecondStep() {
        navController.navigateToTourSecondStep()
    }

    fun navigateToTourThirdStep() {
        navController.navigateToTourThirdStep()
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navController.currentDestination?.route == T::class.qualifiedName

    @Composable
    fun showBottomBar() = MainTabType.contains {
        currentDestination?.route == it::class.qualifiedName
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
