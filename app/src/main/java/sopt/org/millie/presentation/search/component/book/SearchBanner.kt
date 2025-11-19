package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun SearchBanner(
    bannerTitle: String,
    bannerContent: String,
    bannerUrl: String,
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
                .padding(bottom = 23.dp, end = 16.dp),
        ) {
            Text(
                text = bannerTitle,
                modifier = Modifier.padding(top = 21.dp),
                color = MillieTheme.colors.darkGray1,
                style = MillieTheme.typography.title.subHead4,
            )

            Text(
                text = bannerContent,
                color = MillieTheme.colors.gray3,
                style = MillieTheme.typography.body.body1,
            )
        }

        AsyncImage(
            model = bannerUrl,
            contentDescription = null,
            modifier = Modifier
                .size(width = 64.dp, height = 70.dp)
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
        bannerUrl = "",
    )
}
