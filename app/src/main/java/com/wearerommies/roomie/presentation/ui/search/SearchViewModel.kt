package com.wearerommies.roomie.presentation.ui.search

import androidx.lifecycle.ViewModel
import com.wearerommies.roomie.domain.entity.SearchResultEntity
import com.wearerommies.roomie.presentation.core.util.EmptyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
) : ViewModel() {
    // state 관리
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState>
        get() = _state.asStateFlow()

    // side effect 관리
    private val _sideEffect: MutableSharedFlow<SearchSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<SearchSideEffect>
        get() = _sideEffect.asSharedFlow()

    val searchResultList = persistentListOf(
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아아을망라미ㅓ리아ㅓㄹ",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아ㅣ마어라ㅓㄻ이ㅏ러미아아",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아아을망라미ㅓ리아ㅓㄹ",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아ㅣ마어라ㅓㄻ이ㅏ러미아아",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아",
            address = "으아아아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아아아아을망라미ㅓ리아ㅓㄹ",
            address = "으아아adfaafadsfsfa;dkjfa;ldkfj;alsdkfja;아아아",
            roadAddress = "으아아아아아"
        ),
        SearchResultEntity(
            x = 1.0,
            y = 1.0,
            location = "으아아아아ㅣ마어라ㅓㄻ이ㅏ러미아아",
            address = "으아아아fad;lkfjad;lkfjal;kdjfa;lkdfja;ldkfja;ldkfjahkljhlkjhlkjhklhj아아",
            roadAddress = "으아lkdfja;dlfkja;dlfkja;lsdkfja;ldkfja;lkjf아아아kjhlkjhlkhlkjhlkjhlkjlh아"
        )
    )

    fun setSearchKeyword(keyword: String) {
        _state.value = _state.value.copy(
            searchKeyword = keyword
        )
    }

    fun fetchSearchResult() {
        _state.value = _state.value.copy(
            uiState = EmptyUiState.Success(
                searchResultList.toPersistentList()
            )
        )
    }
}
