package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun SearchBookItem(
    imageUrl: String,
    reader: String,
    title: String,
    author: String,
    rate: String,
    minute: String,
    modifier: Modifier = Modifier,
    onClickBookItem: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .width(103.dp)
            .noRippleClickable(
                onClick = onClickBookItem,
            ),
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
        )

        Spacer(modifier = Modifier.height(13.dp))

        SearchAudioTag(
            reader = reader,
        )

        Spacer(modifier = Modifier.height(2.dp))

        SearchTitleAuthor(
            title = title,
            author = author,
        )

        Spacer(modifier = Modifier.height(1.dp))

        SearchWandokRate(
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
