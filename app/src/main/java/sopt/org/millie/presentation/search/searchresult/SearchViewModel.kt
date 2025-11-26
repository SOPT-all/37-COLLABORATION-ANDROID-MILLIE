package sopt.org.millie.presentation.search.searchresult

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.millie.R
import sopt.org.millie.core.util.UiState
import sopt.org.millie.data.repository.SearchRepository
import sopt.org.millie.presentation.search.navigation.SearchResultRoute
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import sopt.org.millie.presentation.search.searchresult.library.model.SearchLibraryModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.Long
import kotlin.String

@HiltViewModel
class SearchViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
        private val searchRepository: SearchRepository,
    ) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    val keyword = savedStateHandle.toRoute<SearchResultRoute>().keyword

    init {
        loadSearchResult(keyword)
        updateText(keyword)
        loadLibraryList()
    }

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

    fun onSearchAction() {
        val keyword = _uiState.value.searchInput
        loadSearchResult(keyword)
    }

    fun loadSearchResult(keyword: String) {
        viewModelScope.launch {
            searchRepository.getBooks(keyword)
                .onSuccess { bookSearchResponseModels ->
                    val bookModels = bookSearchResponseModels.books.map {
                        SearchBookModel(
                            bookId = it.bookId,
                            bookCoverImageUrl = it.bookCoverImageUrl,
                            bookTitle = it.bookTitle,
                            bookAuthor = it.bookAuthor,
                            completionRate = it.completionRate,
                            completionTime = it.completionTime,
                            isAudiobook = it.isAudiobook,
                            voiceActor = it.voiceActor,
                        )
                    }

                    val searchResultData = SearchResultData(
                        bookList = bookModels,
                        banner = bookSearchResponseModels.banner,
                    )

                    _uiState.update {
                        it.copy(searchResult = UiState.Success(searchResultData))
                    }
                }
                .onFailure {
                    Timber.d("FAIL: ${it.message}")
                }
        }
    }

    fun loadLibraryList() {
        val dummyLibraries = listOf(
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
        )
        _uiState.update { it.copy(searchLibraryList = dummyLibraries) }
    }
}
