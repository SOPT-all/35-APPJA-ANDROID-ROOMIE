package com.wearerommies.roomie.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.model.MainTabRoute
import com.wearerommies.roomie.presentation.model.Route

enum class MainTabType(
    @DrawableRes val navIcon: Int,
    @StringRes val navTitle: Int,
    val route: MainTabRoute,
) {
    HOME(
        navIcon = R.drawable.ic_launcher_background,
        navTitle = R.string.home,
        route = MainTabRoute.Home
    ),
    MAP(
        navIcon = R.drawable.ic_launcher_background,
        navTitle = R.string.map,
        route = MainTabRoute.Map
    ),
    MY(
        navIcon = R.drawable.ic_launcher_background,
        navTitle = R.string.mypage,
        route = MainTabRoute.My
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTabType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}