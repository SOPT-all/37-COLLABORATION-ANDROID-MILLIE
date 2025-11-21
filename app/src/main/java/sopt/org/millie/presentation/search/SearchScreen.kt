package sopt.org.millie.presentation.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieSearchTextField
import sopt.org.millie.core.designsystem.component.MillieTabbar
import sopt.org.millie.core.designsystem.component.MillieTopappbar
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.search.book.SearchBookScreen
import sopt.org.millie.presentation.search.model.SearchBannerModel
import sopt.org.millie.presentation.search.model.SearchBookModel

@Composable
fun SearchScreen(
    searchBookList: List<SearchBookModel>,
    searchBanner: SearchBannerModel,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()

    var text by remember { mutableStateOf("") }

    val searchTabs = listOf("도서", "밀리로드", "포스트", "서재")
    val pagerState = rememberPagerState(pageCount = { searchTabs.size })

    Column(
        modifier = modifier,
    ) {
        MillieTopappbar(
            title = "검색결과",
            navigationIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back_button),
                    contentDescription = null,
                    tint = MillieTheme.colors.black,
                )
            },
        )

        HorizontalDivider(
            modifier = Modifier,
            thickness = 1.dp,
            color = MillieTheme.colors.lightGray1,
        )

        MillieSearchTextField(
            value = text,
            onValueChange = { text = it },
            onCancelClick = { text = "" },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        )

        HorizontalDivider(
            modifier = Modifier,
            thickness = 1.dp,
            color = MillieTheme.colors.lightGray1,
        )

        MillieTabbar(
            tabs = searchTabs,
            selectedTab = searchTabs[pagerState.currentPage],
            onTabSelected = { title ->
                val index = searchTabs.indexOf(title)
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },
        )

        Box(
            modifier = Modifier,
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth(),
            ) { page ->
                when (searchTabs[page]) {
                    "도서" -> {
                        SearchBookScreen(
                            bookList = searchBookList,
                            searchBanner = searchBanner,
                        )
                    }

                    "밀리로드" -> {
                        // TODO : 화면 추가
                    }

                    "포스트" -> {
                        // TODO : 화면 추가
                    }

                    "서재" -> {
                        // TODO : 화면 추가
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    MillieTheme {
        SearchScreen(
            searchBookList = listOf(
                SearchBookModel(
                    imageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    reader = "",
                    title = "홍학의 자리",
                    author = "정해연",
                    rate = 36,
                    minute = 533,
                    isAudioEnabled = false,
                ),
                SearchBookModel(
                    imageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    reader = "김지윤,박지윤",
                    title = "홍학의 자리",
                    author = "정해연",
                    rate = 36,
                    minute = 533,
                ),
                SearchBookModel(
                    imageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    reader = "김지윤,박지윤",
                    title = "홍학의 자리",
                    author = "정해연",
                    rate = 36,
                    minute = 533,
                ),
                SearchBookModel(
                    imageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                    reader = "김지윤,박지윤",
                    title = "홍학의 자리",
                    author = "정해연",
                    rate = 36,
                    minute = 533,
                ),
            ),
            searchBanner =
                SearchBannerModel(
                    bannerTitle = "《홍학의 자리》읽을 준비!",
                    bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
                    bannerUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
                ),
        )
    }
}
