package sopt.org.millie.presentation.search.searchresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import sopt.org.millie.core.util.UiState
import sopt.org.millie.data.model.BookSearchResponseModel
import sopt.org.millie.data.repository.SearchRepository
import sopt.org.millie.presentation.search.home.model.BookCategoryModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBannerModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import javax.inject.Inject
import kotlin.Long
import kotlin.String

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
                    val bookModels = bookSearchResponseModels.map {
                        SearchBookModel(
                            bookId = it.books.first().bookId,
                            bookCoverImageUrl = it.books.first().bookCoverImageUrl,
                            bookTitle = it.books.first().bookTitle,
                            bookAuthor = it.books.first().bookAuthor,
                            completionRate = it.books.first().completionRate,
                            completionTime = it.books.first().completionTime,
                            isAudiobook = it.books.first().isAudiobook,
                            voiceActor = it.books.firstOrNull()?.voiceActor
                        )
                    }

                    val bannerModels = bookSearchResponseModels.first().banner
                    _uiState.update {
                        it.copy(
                            searchBookList = UiState.Success(bookModels.toImmutableList()),
                            searchBanner = UiState.Success(bannerModels)
                        )
                    }
                }
                .onFailure { }
        }
    }
}
