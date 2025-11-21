package sopt.org.millie.presentation.search.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.presentation.search.component.SearchTitle
import sopt.org.millie.presentation.search.component.book.SearchBanner

@Composable
fun SearchBookScreen(
    bannerTitle: String,
    bannerContent: String,
    bannerUrl: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 23.dp),
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
        ) {
            /*itemsIndexed(

            ){

            }*/
        }

        Spacer(modifier = Modifier.height(60.dp))

        SearchBanner(
            bannerTitle = bannerTitle,
            bannerContent = bannerContent,
            bannerUrl = bannerUrl,
            modifier = Modifier.padding(horizontal = 25.dp),
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBookScreenPreview() {
    SearchBookScreen(
        bannerTitle = "《홍학의 자리》읽을 준비!",
        bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
        bannerUrl = "",
    )
}
