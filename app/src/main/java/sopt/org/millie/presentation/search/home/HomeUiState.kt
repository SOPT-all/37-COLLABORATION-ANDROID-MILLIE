package sopt.org.millie.presentation.search.home

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import sopt.org.millie.R
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.search.home.constants.HomeConstants
import sopt.org.millie.presentation.search.home.model.BookCategoryModel
import sopt.org.millie.presentation.search.home.model.RankingModel

@Immutable
data class HomeUiState(
    val searchKeyword: String = "",
    val tabs: ImmutableList<String> = HomeConstants.HOME_TABS,
    val selectedTab: String = HomeConstants.DEFAULT_TAB,
    val rankingItem: RankingModel = RankingModel(rank = 2, bookTitle = "동화", rankingIcon = R.drawable.ic_home_ranking_down),
    val categoryList: UiState<ImmutableList<BookCategoryModel>> = UiState.Loading,
)
