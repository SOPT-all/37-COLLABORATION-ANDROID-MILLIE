package sopt.org.millie.presentation.search.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
    onClickBookItem: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 37.dp),
    ) {
        SearchTitle(
            title = "도서",
            count = bookList.size,
            modifier = Modifier.padding(start = 17.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = bookList,
                key = { it.bookId },
            ) { book ->
                SearchBookItem(
                    bookCoverImageUrl = book.bookCoverImageUrl,
                    bookTitle = book.bookTitle,
                    bookAuthor = book.bookAuthor,
                    completionRate = book.completionRate,
                    completionTime = book.completionTime,
                    onClickBookItem = onClickBookItem,
                    isAudiobook = book.isAudiobook,
                    voiceActor = book.voiceActor,
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        SearchBanner(
            bannerTitle = searchBanner.bannerTitle,
            bannerContent = searchBanner.bannerContent,
            bannerImageUrl = searchBanner.bannerImageUrl,
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
        searchBanner =
            SearchBannerModel(
            bannerTitle = "《홍학의 자리》읽을 준비!",
            bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
            bannerImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
        ),
        onClickBookItem = {},
    )
}
