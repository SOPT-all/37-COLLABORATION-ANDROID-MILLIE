package sopt.org.millie.presentation.bookdetail.component.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.bookdetail.component.tag.BookDetailLikedTag
import sopt.org.millie.presentation.bookdetail.model.BookReviewModel

@Composable
fun BookDetailReview(
    bookReview: BookReviewModel,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        UserInfo(
            username = bookReview.username,
        )

        Text(
            text = "${bookReview.dateOfReview}",
            color = MillieTheme.colors.gray2,
            style = MillieTheme.typography.body.caption3,
        )

        Text(
            text = "${bookReview.contentOfReview}",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.body.body1,
        )

        BookDetailLikedTag(
            onClick = onLikeClick,
            likedNum = bookReview.likedNum,
        )
    }
}

@Composable
private fun UserInfo(
    username: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_book_detail_person),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "$username",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.body.body1,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_more),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDetailReview(
            bookReview = BookReviewModel(
                username = "어진 님",
                dateOfReview = "2023.06.06",
                contentOfReview = "저는 책에 오타가 난 줄 알았어요",
                likedNum = 10,
            ),
            onLikeClick = {},
        )
    }
}
