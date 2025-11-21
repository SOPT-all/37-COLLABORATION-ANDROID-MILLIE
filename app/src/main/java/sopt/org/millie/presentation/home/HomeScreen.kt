package sopt.org.millie.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieTabbar
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.home.component.item.BookCategoryItem
import sopt.org.millie.presentation.home.component.item.HomeTitleItem
import sopt.org.millie.presentation.home.component.item.QuickLinks
import sopt.org.millie.presentation.home.component.item.RankingItem
import sopt.org.millie.presentation.home.component.textfield.HomeSearchTextField
import sopt.org.millie.presentation.home.component.topappbar.HomeTopAppBar
import sopt.org.millie.presentation.home.constants.HomeConstants
import sopt.org.millie.presentation.home.model.BookCategoryModel
import sopt.org.millie.presentation.home.model.RankingModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val categoryState = uiState.categoryList) {
        is UiState.Loading -> {
            LoadingScreen()
        }

        is UiState.Success -> {
            HomeScreen(
                value = uiState.searchKeyword,
                onValueChange = viewModel::updateSearchKeyword,
                onCancelClick = viewModel::clearSearch,
                onSearchAction = viewModel::onSearchAction,
                tabs = uiState.tabs,
                selectedTab = uiState.selectedTab,
                onTabSelected = viewModel::selectTab,
                rankingItem = uiState.rankingItem,
                categoryList = categoryState.data,
            )
        }

        is UiState.Failure -> {}
        is UiState.Empty -> {}
    }
}

@Composable
private fun HomeScreen(
    value: String,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    onSearchAction: () -> Unit,
    tabs: List<String>,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    rankingItem: RankingModel,
    categoryList: List<BookCategoryModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MillieTheme.colors.white),
    ) {
        HomeTopAppBar()

        HomeSearchTextField(
            value = value,
            onValueChange = onValueChange,
            onCancelClick = onCancelClick,
            onSearchAction = onSearchAction,
        )

        RankingItem(
            rank = rankingItem.rank,
            bookTitle = rankingItem.bookTitle,
            rankingIcon = rankingItem.rankingIcon,
        )

        QuickLinks()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                MillieTabbar(
                    tabs = tabs,
                    selectedTab = selectedTab,
                    onTabSelected = onTabSelected,
                    horizontalPadding = 23.dp,
                    modifier = Modifier.padding(top = 33.dp, bottom = 8.dp),
                )
            }

            when (selectedTab) {
                "카테고리" -> categoryTabContent(categoryList)
                else -> emptyTabContent(selectedTab)
            }
        }
    }
}

private fun LazyListScope.categoryTabContent(categoryList: List<BookCategoryModel>) {
    item {
        HomeTitleItem(
            title = "카테고리",
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(bottom = 12.dp),
        )
    }

    items(categoryList) { category ->
        BookCategoryItem(
            bookImageUrl = category.imageUrl,
            title = category.title,
            description = category.description,
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(bottom = 13.dp),
        )
    }
}

private fun LazyListScope.emptyTabContent(tabName: String) {
    item {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = tabName,
                style = MillieTheme.typography.title.headLine,
                color = MillieTheme.colors.black,
            )
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MillieTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            color = MillieTheme.colors.millieYellow,
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MillieTheme {
        HomeScreen(
            value = "",
            onValueChange = {},
            onCancelClick = {},
            onSearchAction = {},
            tabs = HomeConstants.HOME_TABS,
            selectedTab = HomeConstants.DEFAULT_TAB,
            onTabSelected = {},
            rankingItem = RankingModel(
                rank = 2,
                bookTitle = "동화",
                rankingIcon = R.drawable.ic_home_ranking_down,
            ),
            categoryList = listOf(
                BookCategoryModel(
                    categoryId = 1,
                    title = "소설",
                    description = "추리/스릴러, SF, 판타지 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 2,
                    title = "세계문학전집",
                    description = "열린책들, 민음사, 현대지성 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 3,
                    title = "에세이",
                    description = "자기계발, 삶, 여행 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 4,
                    title = "시/희곡",
                    description = "현대시, 고전시, 연극 희곡 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 5,
                    title = "인문학",
                    description = "철학, 역사, 심리학 등",
                    imageUrl = "",
                ),
            ),
        )
    }
}
