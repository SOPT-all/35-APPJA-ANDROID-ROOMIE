package com.wearerommies.roomie.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.presentation.navigator.route.MainTabRoute
import com.wearerommies.roomie.presentation.navigator.route.Route

enum class MainTabType(
    @DrawableRes val tabIcon: Int,
    @StringRes val tabTitle: Int,
    val route: MainTabRoute,
) {
    HOME(
        tabIcon = R.drawable.ic_home_line_black_24px,
        tabTitle = R.string.home,
        route = MainTabRoute.Home
    ),
    MAP(
        tabIcon = R.drawable.ic_map_line_black_24px,
        tabTitle = R.string.map,
        route = MainTabRoute.Map(FilterEntity())
    ),
    MY(
        tabIcon = R.drawable.ic_user_line_black_24px,
        tabTitle = R.string.mypage,
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
