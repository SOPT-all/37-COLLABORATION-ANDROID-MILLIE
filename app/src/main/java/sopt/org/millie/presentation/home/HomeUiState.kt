package sopt.org.millie.presentation.home

import androidx.compose.runtime.Immutable
import sopt.org.millie.R
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.home.constants.HomeConstants
import sopt.org.millie.presentation.home.model.BookCategoryModel
import sopt.org.millie.presentation.home.model.RankingModel

@Immutable
data class HomeUiState(
    val searchKeyword: String = "",
    val tabs: List<String> = HomeConstants.HOME_TABS,
    val selectedTab: String = HomeConstants.DEFAULT_TAB,
    val rankingItem: RankingModel = RankingModel(rank = 2, bookTitle = "동화", rankingIcon = R.drawable.ic_home_ranking_down),
    val categoryList: UiState<List<BookCategoryModel>> = UiState.Loading,
)
