package com.wearerommies.roomie.presentation.ui.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun MapRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToSearch: () -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MapSideEffect.ShowToast -> context.showToast(message = sideEffect.message)
                }
            }
    }

    MapScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        navigateToSearch = navigateToSearch,
        state = state.uiState
    )

}

@Composable
fun MapScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToSearch: () -> Unit,
    state: UiState<String>,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = Modifier
            .noRippleClickable { navigateToSearch() },
        text = "MAP",
        color = RoomieTheme.colors.primaryLight1,
        textAlign = TextAlign.Center,
        fontSize = 30.sp
    )
}

@Preview
@Composable
fun MapScreenPreview() {
    RoomieAndroidTheme {
        MapScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            navigateToSearch = {},
            state = UiState.Loading
        )
    }
}
