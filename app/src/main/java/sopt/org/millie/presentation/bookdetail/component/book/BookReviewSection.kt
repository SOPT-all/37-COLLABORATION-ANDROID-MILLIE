package sopt.org.millie.presentation.bookdetail.component.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import sopt.org.millie.presentation.bookdetail.model.BookReviewModel

@Composable
fun BookReviewSection(
    totalReviewCount: Int,
    bookReviews: ImmutableList<BookReviewModel>,
    onReview1LikeClick: () -> Unit,
    onReview2LikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        BookReviewSectionTopbar(
            totalReviewCount = totalReviewCount,
        )

        Spacer(modifier = Modifier.height(40.dp))

        bookReviews.forEachIndexed { index, bookReview ->
            BookDetailReview(
                bookReview = bookReview,
                onLikeClick = if (index == 0) onReview1LikeClick else onReview2LikeClick,
            )

            if (index == 0) Spacer(modifier = Modifier.height(35.dp))
        }
    }
}

@Composable
private fun BookReviewSectionTopbar(
    totalReviewCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "리뷰",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead4,
        )

        Text(
            text = totalReviewCount.toString(),
            color = MillieTheme.colors.milliePurple,
            style = MillieTheme.typography.title.subHead4,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_next),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookReviewSection(
            totalReviewCount = 100,
            bookReviews = persistentListOf(
                BookReviewModel(
                    username = "aaaa",
                    dateOfReview = "2023.01.01",
                    contentOfReview = "리뷰1",
                    likedNum = 100,
                ),
                BookReviewModel(
                    username = "bbbb",
                    dateOfReview = "2023.01.01",
                    contentOfReview = "리뷰2",
                    likedNum = 100,
                ),
            ),
            onReview1LikeClick = {},
            onReview2LikeClick = {},
        )
    }
}
