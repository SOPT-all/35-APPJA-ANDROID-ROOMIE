package com.wearerommies.roomie.presentation.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class BookMarkViewModel @Inject constructor(
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(BookMarkState())
    val state: StateFlow<BookMarkState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<BookMarkSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<BookMarkSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun getBookMarkList() {
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
}