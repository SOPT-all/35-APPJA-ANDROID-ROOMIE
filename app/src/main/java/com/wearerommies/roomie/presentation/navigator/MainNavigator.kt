package com.wearerommies.roomie.presentation.navigator

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.wearerommies.roomie.presentation.model.MainTabRoute
import com.wearerommies.roomie.presentation.model.Route
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.presentation.ui.home.navigateHome
import com.wearerommies.roomie.presentation.ui.map.navigateMap
import com.wearerommies.roomie.presentation.ui.mypage.navigateMy

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTabRoute.Home

    val currentTab: MainTabType?
        @SuppressLint("RestrictedApi") @Composable get() = MainTabType.find { tab ->
            currentDestination?.route == tab::class.qualifiedName
        }

    fun navigate(tab: MainTabType) {
        val navOptions = navOptions {
            popUpTo(MainTabType.HOME.route) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTabType.HOME -> navController.navigateHome(navOptions)
            MainTabType.MAP -> navController.navigateMap(navOptions)
            MainTabType.MY -> navController.navigateMy(navOptions)
        }
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            popBackStack()
        }
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