package sopt.org.millie.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SearchBookItem(
    imageUrl: String,
    reader: String,
    title: String,
    author: String,
    rate: String,
    minute: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(103.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 12.dp),
        )

        BookAudioMark(
            reader = reader,
        )

        BookTitleAuthor(
            title = title,
            author = author,
        )

        BookWandokRate(
            rate = rate,
            minute = minute,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBookItemPreview() {
    SearchBookItem(
        imageUrl = "",
        reader = "김지윤,박지윤",
        title = "홍학의 자리",
        author = "정해연",
        rate = "36%",
        minute = "533분",
    )
}
