package sopt.org.millie.presentation.search.searchresult

import androidx.compose.runtime.Immutable
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBannerModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import sopt.org.millie.presentation.search.searchresult.constants.SearchResultConstants
import sopt.org.millie.presentation.search.searchresult.library.model.SearchLibraryModel

@Immutable
data class SearchUiState(
    val searchInput: String = "",
    val searchTabs: List<String> = SearchResultConstants.SEARCH_TABS,
    val selectedTab: String = SearchResultConstants.SELECTED_TAB,
    val searchBookList: UiState<List<SearchBookModel>> = UiState.Loading,
    val searchLibraryList: UiState<List<SearchLibraryModel>> = UiState.Loading,
    val searchBanner: UiState<SearchBannerModel> = UiState.Loading,
)
