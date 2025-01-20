package com.wearerommies.roomie.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.repository.MapRepository
import com.wearerommies.roomie.presentation.core.util.EmptyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
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
class SearchViewModel @Inject constructor(
    private val mapRepository: MapRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<SearchSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<SearchSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun setSearchKeyword(keyword: String) {
        _state.value = _state.value.copy(
            searchKeyword = keyword
        )
    }

    fun fetchSearchResult(query: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                uiState = EmptyUiState.Loading
            )
            mapRepository.getSearchResult(query)
                .onSuccess { result ->
                    _state.value = _state.value.copy(
                        uiState = if (result.isEmpty()) EmptyUiState.Empty else EmptyUiState.Success(
                            result.toPersistentList()
                        )
                    )
                }
                .onFailure { error ->
                    Timber.e(error)
                }
        }
    }
}
