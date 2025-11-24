package sopt.org.millie.presentation.search.post

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow

@Composable
fun SearchPostItem(
    @DrawableRes postImage: Int,
    title: String,
    description: String,
    @DrawableRes writerImage: Int,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    val postShape = RoundedCornerShape(8.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .customShadow(shape = postShape, color = MillieTheme.colors.black.copy(alpha = 0.05f), offsetY = 4.dp, blur = 21.dp)
            .clip(postShape)
            .background(color = MillieTheme.colors.white),
    ) {
        MillieImage(
            imageUrl = postImage,
            modifier = Modifier
                .align(Alignment.Top)
                .size(width = 91.dp, height = 132.dp),
        )

        Column(
            modifier = Modifier
                .padding(start = 15.dp, end = 14.dp, top = 16.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PostBookInfo(title = title, description = description)

            PostWriterInfo(writerUrl = writerImage, writerName = writerName, writerDate = writerDate)
        }
    }
}

@Composable
private fun PostBookInfo(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            text = title,
            style = MillieTheme.typography.title.subHead2,
            color = MillieTheme.colors.black,
        )

        Text(
            text = description,
            style = MillieTheme.typography.body.caption1,
            color = MillieTheme.colors.gray4,
            modifier = Modifier
                .padding(bottom = 6.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun PostWriterInfo(
    @DrawableRes writerUrl: Int,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MillieImage(
            imageUrl = writerUrl,
            modifier = Modifier
                .align(Alignment.Top)
                .clip(shape = CircleShape)
                .size(25.dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = writerName,
                style = MillieTheme.typography.body.caption1,
                color = MillieTheme.colors.darkGray1,
            )

            Text(
                text = writerDate,
                style = MillieTheme.typography.body.caption4,
                color = MillieTheme.colors.darkGray1,
            )
        }
    }
}

@Composable
private fun MillieImage(
    @DrawableRes imageUrl: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = imageUrl),
        contentDescription = null,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchPostScreenPreview() {
    MillieTheme {
        SearchPostItem(
            postImage = R.drawable.img_searh_post_book,
            title = "홍학의 자리",
            description = "독서를 취미로 삼고자 좋아하는 이꼬르영 유튜버의 추천 및 이미 베스트셀러로 유명세를 타던 홍학의자리를 읽…",
            writerImage = R.drawable.img_search_post_reviewer_1,
            writerName = "뇌쉑걸의 서재",
            writerDate = "2024.02.05",
        )
    }
}
