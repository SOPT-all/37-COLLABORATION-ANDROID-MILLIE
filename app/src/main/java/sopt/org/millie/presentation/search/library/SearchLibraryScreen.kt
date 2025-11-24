package sopt.org.millie.presentation.search.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.presentation.search.component.SearchTitle
import sopt.org.millie.presentation.search.component.library.LibraryItem
import sopt.org.millie.presentation.search.model.SearchLibraryModel

@Composable
fun SearchLibraryScreen(
    libraryList: List<SearchLibraryModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 23.dp)
            .padding(horizontal = 20.dp),
    ) {
        SearchTitle(
            title = "서재",
            count = libraryList.size,
            modifier = Modifier.padding(start = 1.dp),
        )

        Spacer(modifier = Modifier.height(13.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            libraryList.forEach {
                LibraryItem(
                    imgRes = it.imgRes,
                    bookTitle = it.bookTitle,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchLibraryScreenPreview() {
    SearchLibraryScreen(
        libraryList = listOf(
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
            SearchLibraryModel(
                imgRes = R.drawable.img_search_library_1,
                bookTitle = "홍학의 자리",
            ),
        ),
    )
}
