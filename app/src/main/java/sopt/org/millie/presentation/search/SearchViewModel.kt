package sopt.org.millie.presentation.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
    @Inject
    constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onTabSelected(tab: String) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

    fun updateText(newText: String) {
        _uiState.update { it.copy(searchInput = newText) }
    }

    fun clearText() {
        _uiState.update { it.copy(searchInput = "") }
    }

    fun onBookItemClick(bookId: Long) {
        // TODO: 이동 로직 추가
    }
}
