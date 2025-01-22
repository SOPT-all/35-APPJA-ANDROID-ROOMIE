package com.wearerommies.roomie.presentation.ui.webview.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wearerommies.roomie.presentation.navigator.route.Route
import com.wearerommies.roomie.presentation.ui.webview.WebViewRoute

fun NavController.navigateToWebView(webViewUrl: String, navOptions: NavOptions? = null) {
    navigate(
        route = Route.WebView(
            webViewUrl = webViewUrl
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.webViewNavGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    composable<Route.WebView> { backStackEntry ->
        val webViewUrl = backStackEntry.toRoute<Route.WebView>().webViewUrl
        WebViewRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            webViewUrl = webViewUrl
        )
    }
}
