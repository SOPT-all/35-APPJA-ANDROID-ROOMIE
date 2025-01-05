package com.wearerommies.roomie.presentation.reqres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.repository.ReqresRepository
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
class ReqresViewModel @Inject constructor(
    private val reqresRepository: ReqresRepository,
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(ReqresState())
    val state: StateFlow<ReqresState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<ReqresSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<ReqresSideEffect>
        get() = _sideEffect.asSharedFlow()

    val page: Int = 2

    fun getMyJogboList() {
        viewModelScope.launch {
            runCatching {
                reqresRepository.getReqresLists(page)
            }.onSuccess { reqresList ->
                // 데이터 불러오기 성공시에는 state 를 Suceess로 변경해줍니다
                _state.value = _state.value.copy(uiState = UiState.Success("성공루미"))
                // side effect - 화면에서 계속 가지고 있지 않아도 되므로 emit(방출)
                _sideEffect.emit(ReqresSideEffect.ShowToast("데이터 불러오기 성공~!"))

            }.onFailure { error ->
                // 데이터 불러오기 성공시에는 state 를 Failure로 변경해줍니다
                _state.value = _state.value.copy(uiState = UiState.Failure)
                // side effect - 화면에서 계속 가지고 있지 않아도 되므로 emit(방출)
                _sideEffect.emit(ReqresSideEffect.ShowToast("데이터 불러오기 실패ㅠㅠ"))
                Timber.e(error)
            }
        }
    }
}
