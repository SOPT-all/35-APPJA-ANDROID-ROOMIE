package com.wearerommies.roomie.presentation.ui.mood

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.R
import com.wearerommies.roomie.data.service.HouseService
import com.wearerommies.roomie.domain.entity.MoodCardEntity
import com.wearerommies.roomie.presentation.core.util.UiState
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
class MoodViewModel @Inject constructor(
    private val houseService: HouseService,
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(MoodState())
    val state: StateFlow<MoodState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<MoodSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<MoodSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun getMoodList(moodTag: String) = viewModelScope.launch {
        runCatching {
            houseService.getMoodLists(moodTag = moodTag)
        }.onSuccess { response ->
            val moodLists = response.data.let {
                MoodCardEntity(
                    moodTag = it.moodTag,
                    houses = it.houses.map { item ->
                        MoodCardEntity.House(
                            houseId = item.houseId,
                            monthlyRent = item.monthlyRent,
                            deposit = item.deposit,
                            occupancyTypes = item.occupancyTypes,
                            location = item.location,
                            genderPolicy = item.genderPolicy,
                            locationDescription = item.locationDescription,
                            isPinned = item.isPinned,
                            contractTerm = item.contractTerm,
                            mainImgUrl = item.mainImgUrl
                        )
                    }
                )
            }

            _state.value = _state.value.copy(uiState = UiState.Success(moodLists))

        }.onFailure { error ->
            _state.value = _state.value.copy(uiState = UiState.Failure)
            Timber.e(error)
        }
    }


    fun patchHousePin() {
        viewModelScope.launch {
            runCatching {
                //todo: api 연결
            }.onSuccess {
                _sideEffect.emit(
                    MoodSideEffect.SnackBar(
                        message = R.string.add_to_bookmark_list
                    )
                )
            }.onFailure { error ->
                _state.value = _state.value.copy(uiState = UiState.Failure)
                Timber.e(error)
            }
        }
    }
}