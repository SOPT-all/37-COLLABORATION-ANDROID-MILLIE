package sopt.org.millie.presentation.search.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieTabbar
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.search.home.component.item.BookCategoryItem
import sopt.org.millie.presentation.search.home.component.item.HomeTitleItem
import sopt.org.millie.presentation.search.home.component.item.QuickLinks
import sopt.org.millie.presentation.search.home.component.item.RankingItem
import sopt.org.millie.presentation.search.home.component.textfield.HomeSearchTextField
import sopt.org.millie.presentation.search.home.component.topappbar.HomeTopAppBar
import sopt.org.millie.presentation.search.home.constants.HomeConstants
import sopt.org.millie.presentation.search.home.model.BookCategoryModel
import sopt.org.millie.presentation.search.home.model.RankingModel

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    onSearchAction: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.clearSearch()
    }

    when (val categoryState = uiState.categoryList) {
        is UiState.Loading -> {
            LoadingScreen()
        }

        is UiState.Success -> {
            HomeScreen(
                paddingValues = paddingValues,
                uiState = uiState,
                categoryList = categoryState.data,
                onValueChange = viewModel::updateSearchKeyword,
                onCancelClick = viewModel::clearSearch,
                onSearchAction = { onSearchAction(uiState.searchKeyword) },
                onTabSelected = viewModel::selectTab,
            )
        }

        is UiState.Failure -> {}
        is UiState.Empty -> {}
    }
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    uiState: HomeUiState,
    categoryList: ImmutableList<BookCategoryModel>,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    onSearchAction: () -> Unit,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MillieTheme.colors.white)
            .padding(paddingValues),
    ) {
        HomeTopAppBar()

        HomeSearchTextField(
            value = uiState.searchKeyword,
            onValueChange = onValueChange,
            onCancelClick = onCancelClick,
            onSearchAction = onSearchAction,
        )

        RankingItem(
            rank = uiState.rankingItem.rank,
            bookTitle = uiState.rankingItem.bookTitle,
            rankingIcon = uiState.rankingItem.rankingIcon,
        )

        QuickLinks()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                MillieTabbar(
                    tabs = uiState.tabs,
                    selectedTab = uiState.selectedTab,
                    onTabSelected = onTabSelected,
                    horizontalPadding = 23.dp,
                    modifier = Modifier.padding(top = 33.dp, bottom = 8.dp),
                )
            }

            when (uiState.selectedTab) {
                "카테고리" -> categoryTabContent(categoryList)
                else -> emptyTabContent(uiState.selectedTab)
            }
        }
    }
}

private fun LazyListScope.categoryTabContent(categoryList: ImmutableList<BookCategoryModel>) {
    item {
        HomeTitleItem(
            title = "카테고리",
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(bottom = 12.dp),
        )
    }

    items(
        items = categoryList,
        key = { it.categoryId },
    ) { category ->
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
            paddingValues = PaddingValues(0.dp),
            uiState = HomeUiState(
                searchKeyword = "",
                tabs = HomeConstants.HOME_TABS,
                selectedTab = HomeConstants.DEFAULT_TAB,
                rankingItem = RankingModel(
                    rank = 2,
                    bookTitle = "동화",
                    rankingIcon = R.drawable.ic_home_ranking_down,
                ),
                categoryList = UiState.Success(persistentListOf()),
            ),
            categoryList = persistentListOf(
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
            onValueChange = {},
            onCancelClick = {},
            onSearchAction = {},
            onTabSelected = {},
        )
    }
}
