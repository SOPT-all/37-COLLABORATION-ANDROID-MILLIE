package sopt.org.millie.presentation.search.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.presentation.search.component.SearchTitle
import sopt.org.millie.presentation.search.component.book.SearchBanner
import sopt.org.millie.presentation.search.component.book.SearchBookItem
import sopt.org.millie.presentation.search.model.SearchBannerModel
import sopt.org.millie.presentation.search.model.SearchBookModel

@Composable
fun SearchBookScreen(
    bookList: List<SearchBookModel>,
    searchBanner: SearchBannerModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 23.dp),
    ) {
        SearchTitle(
            title = "도서",
            count = 4,
            modifier = Modifier.padding(start = 17.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                count = bookList.size,
            ) {
                SearchBookItem(
                    imageUrl = bookList[it].imageUrl,
                    reader = bookList[it].reader,
                    title = bookList[it].title,
                    author = bookList[it].author,
                    rate = bookList[it].rate,
                    minute = bookList[it].minute,
                    onClickBookItem = {},
                    isAudioEnabled = bookList[it].isAudioEnabled,
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        SearchBanner(
            bannerTitle = searchBanner.bannerTitle,
            bannerContent = searchBanner.bannerContent,
            bannerUrl = searchBanner.bannerUrl,
            modifier = Modifier.padding(horizontal = 25.dp),
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBookScreenPreview() {
    SearchBookScreen(
        bookList = listOf(
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
