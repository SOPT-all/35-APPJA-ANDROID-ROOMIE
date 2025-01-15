package com.wearerommies.roomie.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.R
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
class HomeViewModel @Inject constructor(
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<HomeSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<HomeSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun getHomeData() {
        viewModelScope.launch {
            runCatching {
                //todo: api 연결
            }.onSuccess {
                _state.value = _state.value.copy(uiState = UiState.Success("성공"))

            }.onFailure { error ->
                _state.value = _state.value.copy(uiState = UiState.Failure)
                Timber.e(error)
            }
        }
    }

    fun navigateToBookmark() {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToBookMark)
        }
    }

    fun navigateToMood() {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToMood)
        }
    }

    fun patchHousePin() {
        viewModelScope.launch {
            runCatching {
                //todo: api 연결
            }.onSuccess {
                _sideEffect.emit(
                    HomeSideEffect.SnackBar(
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