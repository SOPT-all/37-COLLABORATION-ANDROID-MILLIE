package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SearchBanner(
    bannerUrl: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(311.dp)
            .height(84.dp)
            .clip(RoundedCornerShape(11.dp)),
    ) {
        AsyncImage(
            model = bannerUrl,
            contentDescription = "배너",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BookBannerPreview() {
    SearchBanner(
        bannerUrl = "",
    )
}
