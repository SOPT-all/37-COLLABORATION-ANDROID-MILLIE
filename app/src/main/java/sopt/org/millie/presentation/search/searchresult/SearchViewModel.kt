package sopt.org.millie.presentation.search.searchresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.millie.data.repository.SearchRepository
import javax.inject.Inject
import kotlin.Long

@HiltViewModel
class SearchViewModel
    @Inject
    constructor(
        private val searchRepository: SearchRepository,
    ) : ViewModel() {
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

    fun loadBooks(keyword: String) {
        viewModelScope.launch {
            searchRepository.getBooks(keyword)
                .onSuccess { bookSearchResponseModels ->
                }
        }
    }
}
