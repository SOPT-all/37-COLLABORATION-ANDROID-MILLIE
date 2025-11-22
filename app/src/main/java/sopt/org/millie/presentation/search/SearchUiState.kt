package sopt.org.millie.presentation.search

import androidx.compose.runtime.Immutable
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.search.constants.SearchConstants
import sopt.org.millie.presentation.search.model.SearchBannerModel
import sopt.org.millie.presentation.search.model.SearchBookModel
import sopt.org.millie.presentation.search.model.SearchLibraryModel

@Immutable
data class SearchUiState(
    val searchTabs: List<String> = SearchConstants.SEARCH_TABS,
    val selectedTab: String = SearchConstants.SELECTED_TAB,
    val searchBookList: UiState<List<SearchBookModel>> = UiState.Loading,
    val searchLibraryList: UiState<List<SearchLibraryModel>> = UiState.Loading,
    val searchBanner: UiState<SearchBannerModel> = UiState.Loading,
)
