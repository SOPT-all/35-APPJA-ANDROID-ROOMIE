package com.wearerommies.roomie.presentation.navigator

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wearerommies.roomie.presentation.navigator.component.BottomNavigationBar
import com.wearerommies.roomie.presentation.navigator.component.RoomieNavHost
import com.wearerommies.roomie.presentation.type.MainTabType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import okhttp3.internal.toImmutableList

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    val snackBarHostState = remember { SnackbarHostState() }

    MainScreenContent(
        navigator = navigator,
        snackBarHostState = snackBarHostState
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        content = { padding ->
            RoomieNavHost(
                navigator = navigator,
                padding = padding
            )
        },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.navigationBarsPadding(),
                isVisible = navigator.showBottomBar(),
                bottomNaviBarItems = MainTabType.entries.toImmutableList(),
                currentNavItemSelected = navigator.currentTab,
                onBottomNaviBarItemSelected = { navigator.navigate(it) }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RoomieAndroidTheme {
        MainScreen(navigator = rememberMainNavigator())
    }
}