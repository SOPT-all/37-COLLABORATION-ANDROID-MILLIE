package sopt.org.millie.presentation.bookdetail.component.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.bookdetail.model.BookSimilarModel

@Composable
fun BookSimilarSection(
    books: ImmutableList<BookSimilarModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        BookSimilarSectionTopbar()

        BookSimilarLists(
            books = books,
        )
    }
}

@Composable
private fun BookSimilarSectionTopbar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "이 책과 비슷한 책",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead4,
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_next),
            contentDescription = null,
        )
    }
}

@Composable
private fun BookSimilarLists(
    books: ImmutableList<BookSimilarModel>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(items = books, key = { _, book -> book.bookImage}) { index, book ->
            BookDetailBook(
                bookImage = book.bookImage,
                bookTitle = book.bookTitle,
                bookAuthor = book.bookAuthor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookSimilarLists(
            books = persistentListOf(
                BookSimilarModel(
                    bookImage = R.drawable.img_detail_book1,
                    bookTitle = "사탄탱고",
                    bookAuthor = "크러스너호르커이",
                ),
                BookSimilarModel(
                    bookImage = R.drawable.img_detail_book2,
                    bookTitle = "사탄탱고",
                    bookAuthor = "크러스너호르커이",
                ),
                BookSimilarModel(
                    bookImage = R.drawable.img_detail_book3,
                    bookTitle = "사탄탱고",
                    bookAuthor = "크러스너호르커이",
                ),
                BookSimilarModel(
                    bookImage = R.drawable.img_detail_book4,
                    bookTitle = "사탄탱고",
                    bookAuthor = "크러스너호르커이",
                ),
            ),
        )
    }
}
