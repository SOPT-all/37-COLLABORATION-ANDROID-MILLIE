package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow

@Composable
fun SearchBanner(
    bannerTitle: String,
    bannerContent: String,
    bannerImageUrl: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(11.dp))
            .background(color = MillieTheme.colors.bannerColor)
            .padding(start = 7.dp, end = 18.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 21.dp, bottom = 23.dp, end = 16.dp),
        ) {
            Text(
                text = bannerTitle,
                color = MillieTheme.colors.darkGray1,
                style = MillieTheme.typography.title.subHead4,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = bannerContent,
                color = MillieTheme.colors.gray3,
                style = MillieTheme.typography.body.body1,
            )
        }

        AsyncImage(
            model = bannerImageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(width = 64.dp, height = 70.dp)
                .customShadow(
                    shape = RoundedCornerShape(topEnd = 4.dp),
                    color = MillieTheme.colors.black.copy(alpha = 0.05f),
                    blur = 4.dp,
                    offsetX = 2.dp,
                    offsetY = (-4).dp,
                )
                .clip(RoundedCornerShape(topEnd = 4.dp))
                .align(Alignment.Bottom),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BookBannerPreview() {
    SearchBanner(
        bannerTitle = "《홍학의 자리》읽을 준비!",
        bannerContent = "  ‘이 책'부터 읽어야 재미가 2배",
        bannerImageUrl = "",
    )
}
