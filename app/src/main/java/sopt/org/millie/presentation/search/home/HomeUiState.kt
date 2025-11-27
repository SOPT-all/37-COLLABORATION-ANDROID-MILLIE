package sopt.org.millie.presentation.search.home

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
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
    val rankingList: ImmutableList<RankingModel> = persistentListOf(
        RankingModel(rank = 1, bookTitle = "소설", rankingIcon = R.drawable.ic_home_ranking_up),
        RankingModel(rank = 2, bookTitle = "동화", rankingIcon = R.drawable.ic_home_ranking_down),
        RankingModel(rank = 3, bookTitle = "에세이", rankingIcon = R.drawable.ic_home_ranking_up),
        RankingModel(rank = 4, bookTitle = "인문학", rankingIcon = R.drawable.ic_home_ranking_down),
        RankingModel(rank = 5, bookTitle = "자기계발", rankingIcon = R.drawable.ic_home_ranking_up),
        RankingModel(rank = 6, bookTitle = "경제경영", rankingIcon = R.drawable.ic_home_ranking_down),
        RankingModel(rank = 7, bookTitle = "과학", rankingIcon = R.drawable.ic_home_ranking_down),
        RankingModel(rank = 8, bookTitle = "역사", rankingIcon = R.drawable.ic_home_ranking_up),
        RankingModel(rank = 9, bookTitle = "예술", rankingIcon = R.drawable.ic_home_ranking_down),
        RankingModel(rank = 10, bookTitle = "여행", rankingIcon = R.drawable.ic_home_ranking_up),
    ),
    val categoryList: UiState<ImmutableList<BookCategoryModel>> = UiState.Loading,
)
