package com.wearerommies.roomie.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.HomeDataEntity
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val houseRepository: HouseRepository
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<HomeSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<HomeSideEffect>
        get() = _sideEffect.asSharedFlow()

    suspend fun getHomeData() {
        userRepository.getHomeData()
            .onSuccess { response ->
                val homeData = response.let {
                    HomeDataEntity(
                        name = it.name,
                        location = it.location,
                        recentlyViewedHouses = it.recentlyViewedHouses.map { item ->
                            RoomCardEntity(
                                houseId = item.houseId,
                                monthlyRent = item.monthlyRent,
                                deposit = item.deposit,
                                occupancyType = item.occupancyType,
                                location = item.location,
                                genderPolicy = item.genderPolicy,
                                locationDescription = item.locationDescription,
                                isPinned = item.isPinned,
                                moodTag = item.moodTag,
                                contractTerm = item.contractTerm,
                                mainImgUrl = item.mainImgUrl
                            )
                        }
                    )
                }

                _state.value = _state.value.copy(uiState = homeData)

            }.onFailure { error ->
                Timber.e(error)
            }
    }

    fun navigateToBookmark() {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToBookMark)
        }
    }

    fun navigateToMap() = viewModelScope.launch {
        _sideEffect.emit(HomeSideEffect.NavigateToMap)
    }


    fun navigateToMood(moodTag: String) {
        viewModelScope.launch {
            _sideEffect.emit(
                HomeSideEffect.NavigateToMood(
                    moodTag = moodTag
                )
            )
        }
    }

    fun bookmarkHouse(houseId: Long) = viewModelScope.launch {
        houseRepository.bookmarkHouse(houseId = houseId)
            .onSuccess { isNotBookmarked ->
                if (isNotBookmarked) {
                    _sideEffect.emit(
                        HomeSideEffect.SnackBar(
                            message = R.string.add_to_bookmark_list
                        )
                    )
                }
            }.onFailure { error ->
                Timber.e(error)
            }
    }

}