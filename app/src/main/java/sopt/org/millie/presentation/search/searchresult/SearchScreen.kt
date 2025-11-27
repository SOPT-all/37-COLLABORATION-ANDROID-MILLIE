package sopt.org.millie.presentation.search.searchresult

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieSearchTextField
import sopt.org.millie.core.designsystem.component.MillieTabbar
import sopt.org.millie.core.designsystem.component.MillieTopappbar
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.UiState
import sopt.org.millie.core.util.noRippleClickable
import sopt.org.millie.presentation.search.searchresult.book.SearchBookScreen
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBannerModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import sopt.org.millie.presentation.search.searchresult.constants.SearchResultConstants
import sopt.org.millie.presentation.search.searchresult.library.SearchLibraryScreen
import sopt.org.millie.presentation.search.searchresult.library.model.SearchLibraryModel
import sopt.org.millie.presentation.search.searchresult.post.SearchPostScreen

@Composable
fun SearchRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToBookDetail: (Long) -> Unit,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    val searchUiState by searchViewModel.uiState.collectAsStateWithLifecycle()

    when (val searchResultState = searchUiState.searchResult) {
        is UiState.Success -> {
            SearchScreen(
                state = searchUiState,
                searchBookList = searchResultState.data.bookList,
                searchLibraryList = searchUiState.searchLibraryList,
                searchBanner = searchResultState.data.banner,
                onValueChange = searchViewModel::updateText,
                onCancelClick = searchViewModel::clearText,
                onSelectedTab = searchViewModel::onTabSelected,
                onSearchAction = searchViewModel::onSearchAction,
                onBookItemClick = navigateToBookDetail,
                onBackButtonClick = navigateUp,
            )
        }

        is UiState.Loading -> {}
        is UiState.Failure -> {}
        is UiState.Empty -> {}
    }
}

@Composable
private fun SearchScreen(
    state: SearchUiState,
    searchBookList: List<SearchBookModel>,
    searchLibraryList: List<SearchLibraryModel>,
    searchBanner: SearchBannerModel,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    onSelectedTab: (String) -> Unit,
    onSearchAction: () -> Unit,
    onBookItemClick: (Long) -> Unit,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MillieTheme.colors.white),
    ) {
        MillieTopappbar(
            title = "검색결과",
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .noRippleClickable(onClick = onBackButtonClick),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back_button),
                    contentDescription = null,
                    tint = MillieTheme.colors.darkGray1,
                )
            },
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = MillieTheme.colors.lightGray1,
        )

        MillieSearchTextField(
            value = state.searchInput,
            onValueChange = onValueChange,
            onCancelClick = onCancelClick,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            onSearchAction = onSearchAction,
        )

        HorizontalDivider(
            modifier = Modifier,
            thickness = 1.dp,
            color = MillieTheme.colors.lightGray2,
        )

        MillieTabbar(
            tabs = state.searchTabs,
            selectedTab = state.selectedTab,
            onTabSelected = onSelectedTab,
        )

        when (state.selectedTab) {
            "도서" -> {
                SearchBookScreen(
                    bookList = searchBookList,
                    searchBanner = searchBanner,
                    onBookItemClick = onBookItemClick,
                )
            }

            "밀리로드" -> {
                // TODO : 화면 추가
            }

            "포스트" -> {
               SearchPostScreen()
            }

            "서재" -> {
                SearchLibraryScreen(
                    libraryList = searchLibraryList,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    MillieTheme {
        var text by remember { mutableStateOf("") }
        var selectedTab by remember { mutableStateOf(SearchResultConstants.SELECTED_TAB) }

        SearchScreen(
            state = SearchUiState(
                searchInput = "",
                searchTabs = SearchResultConstants.SEARCH_TABS,
                selectedTab = SearchResultConstants.SELECTED_TAB,
            ),
            onValueChange = { text = it },
            onCancelClick = { text = "" },
            onSelectedTab = { selectedTab = it },
            searchBookList = listOf(
                SearchBookModel(
                    bookId = 1,
                    bookCoverImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    bookTitle = "홍학의 자리",
                    bookAuthor = "정해연",
                    completionRate = 36,
                    completionTime = 533,
                ),
                SearchBookModel(
                    bookId = 2,
                    bookCoverImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    bookTitle = "홍학의 자리",
                    bookAuthor = "정해연",
                    completionRate = 36,
                    completionTime = 533,
                    isAudiobook = true,
                    voiceActor = "김지윤,박지윤",
                ),
                SearchBookModel(
                    bookId = 3,
                    bookCoverImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    bookTitle = "홍학의 자리",
                    bookAuthor = "정해연",
                    completionRate = 36,
                    completionTime = 533,
                    isAudiobook = true,
                    voiceActor = "김지윤,박지윤",
                ),
                SearchBookModel(
                    bookId = 4,
                    bookCoverImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    bookTitle = "홍학의 자리",
                    bookAuthor = "정해연",
                    completionRate = 36,
                    completionTime = 533,
                    isAudiobook = true,
                    voiceActor = "김지윤,박지윤",
                ),
            ),
            searchLibraryList = listOf(
                SearchLibraryModel(
                    imgRes = R.drawable.img_search_library_1,
                    bookTitle = "홍학의 자리",
                ),
                SearchLibraryModel(
                    imgRes = R.drawable.img_search_library_2,
                    bookTitle = "홍학의 자리",
                ),
                SearchLibraryModel(
                    imgRes = R.drawable.img_search_library_1,
                    bookTitle = "홍학의 자리",
                ),
                SearchLibraryModel(
                    imgRes = R.drawable.img_search_library_3,
                    bookTitle = "홍학의 자리",
                ),
            ),
            searchBanner =
                SearchBannerModel(
                    bannerId = 1,
                    bannerTitle = "《홍학의 자리》읽을 준비!",
                    bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
                    bannerImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                ),
            onSearchAction = {},
            onBookItemClick = {},
            onBackButtonClick = {},
        )
    }
}
