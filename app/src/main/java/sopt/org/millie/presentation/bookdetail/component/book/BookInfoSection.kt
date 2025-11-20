package sopt.org.millie.presentation.bookdetail.component.book

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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

@Composable
fun BookInfoSection(
    bookTitle: String,
    bookAuthor: String,
    bookType: String,
    publishDate: String,
    totalReviewCount: Int,
    bookRate: Float,
    completionRate: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = "$bookTitle",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.headLine,
        )

        Text(
            text = "$bookAuthor $bookType·$publishDate",
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.body1,
        )

        BookStatsSection(
            totalReviewCount = totalReviewCount,
            bookRate = bookRate,
            completionRate = completionRate,
        )
    }
}

@Composable
private fun BookStatsSection(
    totalReviewCount: Int,
    bookRate: Float,
    completionRate: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BookStatsItem(
            imageRes = R.drawable.ic_detail_review,
            label = "리뷰",
            value = "${totalReviewCount}건",
        )

        VerticalDivider(
            thickness = 1.dp,
            color = MillieTheme.colors.gray2,
            modifier = Modifier.height(55.dp),
        )

        BookStatsItem(
            imageRes = R.drawable.ic_detail_star_empty,
            label = "평점",
            value = "$bookRate",
        )

        VerticalDivider(
            thickness = 1.dp,
            color = MillieTheme.colors.gray2,
            modifier = Modifier.height(55.dp),
        )

        BookStatsItem(
            imageRes = R.drawable.ic_detail_review,
            label = "완독률",
            value = "$completionRate%",
        )
    }
}

@Composable
private fun BookStatsItem(
    @DrawableRes imageRes: Int,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = imageRes),
            contentDescription = null,
            tint = Color.Unspecified,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "$label ",
                color = MillieTheme.colors.black,
                style = MillieTheme.typography.body.body1,
            )

            Text(
                text = value,
                color = MillieTheme.colors.black,
                style = MillieTheme.typography.title.subHead2,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookInfoSection(
            bookTitle = "홍학의 자리",
            bookAuthor = "정해연",
            bookType = "장편소설",
            publishDate = "2021.07.21",
            totalReviewCount = 139,
            bookRate = 3.9f,
            completionRate = 80,
        )
    }
}
