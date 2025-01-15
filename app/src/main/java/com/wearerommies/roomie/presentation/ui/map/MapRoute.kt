package com.wearerommies.roomie.presentation.ui.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.naver.maps.geometry.LatLng
import com.naver.maps.geometry.LatLngBounds
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import com.naver.maps.map.overlay.OverlayImage
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.HouseEntity
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.ui.map.component.MapBotomSheet
import com.wearerommies.roomie.presentation.ui.map.component.MapTopBar
import com.wearerommies.roomie.presentation.ui.map.component.MarkerDetailCard
import com.wearerommies.roomie.presentation.ui.map.model.MarkerDetailModel
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun MapRoute(
    paddingValues: PaddingValues,
    navigateToSearch: () -> Unit,
    navigateToFilter: () -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.fetchInitialLocation()
        viewModel.fetchHouseList()
    }

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
        navigateToSearch = navigateToSearch,
        navigateToFilter = navigateToFilter,
        isBottomSheetOpened = state.isBottomSheetOpened,
        latitude = state.latitude,
        longitude = state.longitude,
        houseList = state.houseList,
        onMarkerClicked = viewModel::showMarkerDetail,
        markerDetail = state.markerDetail,
        clickedMarkerId = state.clickedMarkerId,
        resetClickedMarker = viewModel::resetClickedMarker,
        setBottomSheetState = viewModel::setBottomSheetState
    )
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    paddingValues: PaddingValues,
    navigateToSearch: () -> Unit,
    navigateToFilter: () -> Unit,
    isBottomSheetOpened: Boolean,
    latitude: Double,
    longitude: Double,
    houseList: PersistentList<HouseEntity>,
    onMarkerClicked: (Int) -> Unit,
    markerDetail: MarkerDetailModel,
    clickedMarkerId: Int?,
    resetClickedMarker: () -> Unit,
    setBottomSheetState: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val initialCameraPosition = LatLng(latitude, longitude) // 초기 위치 임시 고정
    val initialZoomLevel = 12.0
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(initialCameraPosition, initialZoomLevel)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(RoomieTheme.colors.grayScale1)
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        // TODO: 기획-디자인과 카메라 범위 자동 조정 -> 현재는 모든 마커가 나타나도록 조정되어 있음
        LaunchedEffect(houseList) {
            if (houseList.isNotEmpty()) {
                val bounds = LatLngBounds.Builder()
                houseList.forEach { marker ->
                    bounds.include(LatLng(marker.x, marker.y))
                }

                cameraPositionState.move(
                    CameraUpdate.scrollAndZoomTo(initialCameraPosition, initialZoomLevel)
                )
            }
        }

        NaverMap(
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(isZoomControlEnabled = false),
            onMapClick = { _, _ ->
                resetClickedMarker()
                setBottomSheetState(true)
                cameraPositionState.move(
                    CameraUpdate.scrollAndZoomTo(initialCameraPosition, initialZoomLevel)
                        .animate(CameraAnimation.Fly)
                )
            }
        ) {
            houseList.forEach { marker ->
                Marker(
                    state = MarkerState(LatLng(marker.x, marker.y)),
                    icon = if (marker.houseId == clickedMarkerId)
                        OverlayImage.fromResource(R.drawable.ic_map_pin_active)
                    else OverlayImage.fromResource(R.drawable.ic_map_pin_normal),
                    onClick = {
                        onMarkerClicked(marker.houseId)
                        setBottomSheetState(false)
                        cameraPositionState.move(
                            CameraUpdate.scrollAndZoomTo(
                                LatLng(marker.x, marker.y),
                                15.0
                            )
                                .animate(CameraAnimation.Fly) // TODO: 기획-디자인과 카메라 이동 애니메이션 상의
                        )
                        true
                    },
                    width = 36.dp,
                    height = 40.dp
                )
            }
        }

        MapTopBar(
            onClickSearchTextField = navigateToSearch,
            onClickFilterButton = navigateToFilter,
            modifier = Modifier
                .statusBarsPadding()
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)
        )

        if (clickedMarkerId != null)
            MarkerDetailCard(
                monthlyRent = markerDetail.monthlyRent,
                deposit = markerDetail.deposit,
                contractTerm = markerDetail.contractTerm,
                gender = markerDetail.gender,
                occupancy = markerDetail.occupancy,
                location = markerDetail.location,
                locationDescription = markerDetail.locationDescription,
                moodTag = markerDetail.moodTag,
                onClick = {}, // TODO: 상세 매물 페이지로 이동
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
            )

        if (isBottomSheetOpened) MapBotomSheet()
    }
}

@Preview
@Composable
fun MapScreenPreview() {
    RoomieAndroidTheme {
        MapScreen(
            paddingValues = PaddingValues(),
            navigateToSearch = {},
            navigateToFilter = {},
            isBottomSheetOpened = false,
            latitude = 0.0,
            longitude = 0.0,
            houseList = persistentListOf(),
            onMarkerClicked = {},
            markerDetail = MarkerDetailModel(
                houseId = 1,
                monthlyRent = "30~50",
                deposit = "200~300",
                contractTerm = 6,
                gender = "여성전용",
                occupancy = "1,2인실",
                location = "서대문구 연희동",
                locationDescription = "자이아파트",
                moodTag = "#차분한"
            ),
            clickedMarkerId = null,
            resetClickedMarker = {},
            setBottomSheetState = {}
        )
    }
}
