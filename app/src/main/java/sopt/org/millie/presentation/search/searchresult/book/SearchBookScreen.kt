package sopt.org.millie.presentation.search.searchresult.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.presentation.search.searchresult.book.component.SearchBanner
import sopt.org.millie.presentation.search.searchresult.book.component.SearchBookItem
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBannerModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import sopt.org.millie.presentation.search.searchresult.component.SearchTitle

@Composable
fun SearchBookScreen(
    bookList: List<SearchBookModel>,
    searchBanner: SearchBannerModel,
    onBookItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 17.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) },
        ) {
            SearchTitle(
                title = "도서",
                count = bookList.size,
            )
        }

        items(
            items = bookList,
            key = { it.bookId },
        ) { book ->
            SearchBookItem(
                bookId = book.bookId,
                bookCoverImageUrl = book.bookCoverImageUrl,
                bookTitle = book.bookTitle,
                bookAuthor = book.bookAuthor,
                completionRate = book.completionRate,
                completionTime = book.completionTime,
                onBookItemClick = { onBookItemClick(book.bookId) },
                isAudiobook = book.isAudiobook,
                voiceActor = book.voiceActor,
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) },
        ) {
            Column {
                Spacer(modifier = Modifier.height(50.dp))

                SearchBanner(
                    bannerTitle = searchBanner.bannerTitle,
                    bannerContent = searchBanner.bannerContent,
                    bannerImageUrl = searchBanner.bannerImageUrl,
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                )

                Spacer(modifier = Modifier.height(17.dp))
            }
        }
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
                bannerId = 1,
                bannerTitle = "《홍학의 자리》읽을 준비!",
                bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
                bannerImageUrl = "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954681155.jpg",
        ),
        onBookItemClick = {},
    )
}
