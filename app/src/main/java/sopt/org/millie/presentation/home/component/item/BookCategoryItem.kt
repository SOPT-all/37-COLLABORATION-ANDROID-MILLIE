package sopt.org.millie.presentation.home.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun BookCategoryItem(
    bookImageUrl: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    showRecentBadge: Boolean = false,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = MillieTheme.colors.white)
            .border(
                width = 1.dp,
                color = if (showRecentBadge) MillieTheme.colors.millieYellow else MillieTheme.colors.lightGray1,
                shape = RoundedCornerShape(8.dp),
            ),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 14.dp, top = 17.dp, bottom = 19.dp, end = 107.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            Text(
                text = title,
                style = MillieTheme.typography.title.subHead4,
                color = MillieTheme.colors.black,
            )
            Text(
                text = description,
                style = MillieTheme.typography.body.subBody1,
                color = MillieTheme.colors.gray2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        BookImage(
            bookImageUrl = bookImageUrl,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(89.dp, 75.dp),
        )

        if (showRecentBadge) {
            RecentBadge(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
            )
        }
    }
}

@Composable
private fun RecentBadge(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = MillieTheme.colors.millieYellow)
            .padding(horizontal = 5.dp)
            .padding(top = 3.dp, bottom = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "최근 열어본",
            style = MillieTheme.typography.body.caption4,
            color = MillieTheme.colors.black,
        )
    }
}

@Composable
private fun BookImage(
    bookImageUrl: String,
    modifier: Modifier = Modifier,
) {
    if (bookImageUrl.isNotEmpty()) {
        AsyncImage(
            model = bookImageUrl,
            contentDescription = null,
            modifier = modifier,
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.img_home_category_book),
            contentDescription = null,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
private fun BookCategoryItemWithBadgePreview() {
    MillieTheme {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            BookCategoryItem(
                bookImageUrl = "",
                title = "소설",
                description = "추리/스릴러,킬러 스파이,범의학 스릴러,⋯",
                showRecentBadge = true,
            )

            BookCategoryItem(
                bookImageUrl = "",
                title = "세계문학전집",
                description = "열린책들,민음사,현대지성,을유문화사,살…",
                showRecentBadge = false,
            )
        }
    }
}
