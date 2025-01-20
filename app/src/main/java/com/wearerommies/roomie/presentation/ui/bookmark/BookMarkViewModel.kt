package com.wearerommies.roomie.presentation.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.presentation.core.util.EmptyUiState
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
class BookMarkViewModel @Inject constructor(
    private val houseRepository: HouseRepository
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(BookMarkState())
    val state: StateFlow<BookMarkState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<BookMarkSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<BookMarkSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun getBookMarkList() = viewModelScope.launch {
        houseRepository.getBookmarkLists()
            .onSuccess { result ->
                val bookmarkList = result.map { item ->
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

                if (result.isEmpty()) {
                    _state.value = _state.value.copy(uiState = EmptyUiState.Empty)
                } else {
                    _state.value = _state.value.copy(uiState = EmptyUiState.Success(bookmarkList))
                }

            }.onFailure { error ->
                _state.value = _state.value.copy(uiState = EmptyUiState.Failure)
                Timber.e(error)
            }
    }

    fun patchHousePin() {
        viewModelScope.launch {
            runCatching {
                //todo: api 연결
            }.onSuccess {
                _sideEffect.emit(
                    BookMarkSideEffect.SnackBar(
                        message = R.string.add_to_bookmark_list
                    )
                )
            }.onFailure { error ->
                _state.value = _state.value.copy(uiState = EmptyUiState.Failure)
                Timber.e(error)
            }
        }
    }
}