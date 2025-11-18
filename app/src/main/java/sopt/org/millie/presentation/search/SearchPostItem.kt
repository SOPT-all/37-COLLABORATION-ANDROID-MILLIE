package sopt.org.millie.presentation.search

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.component.MillieImage
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun PostItem(
    postImageUrl: String,
    title: String,
    description: String,
    writerUrl: String,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = MillieTheme.colors.white),
    ) {
        MillieImage(
            imageUrl = postImageUrl,
            modifier = modifier
                .align(Alignment.TopStart)
                .size(91.dp, 132.dp),
        )
        Column(
            modifier = Modifier
                .padding(start = 107.dp, end = 2.dp, top = 16.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PostBookInfo(title, description)
            PostWriterInfo(writerUrl, writerName, writerDate)
        }
    }
}

@Composable
fun PostBookInfo(
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
            modifier = modifier
                .padding(bottom = 6.dp),
        )
    }
}

@Composable
fun PostWriterInfo(
    writerUrl: String,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
    ) {
        MillieImage(
            imageUrl = writerUrl,
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(25.dp, 25.dp),
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 33.dp),
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

@Preview(showBackground = true)
@Composable
private fun SerchPsotPreview() {
    MillieTheme {
        PostItem(
            postImageUrl = "",
            title = "홍학의 자리",
            description = "독서를 취미로 삼고자 좋아하는 이꼬르영 유튜버의 추천 및 이미 베스트셀러로 유명세를 타던 홍학의자리를 읽…",
            writerUrl = "",
            writerName = "뇌쉑걸의 서재",
            writerDate = "2024.02.05",
        )
    }
}
