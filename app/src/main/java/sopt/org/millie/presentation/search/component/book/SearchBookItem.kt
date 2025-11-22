package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun SearchBookItem(
    bookId: Long,
    bookCoverImageUrl: String,
    bookTitle: String,
    bookAuthor: String,
    completionRate: Int,
    completionTime: Int,
    onBookItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    isAudiobook: Boolean = false,
    voiceActor: String = "",
) {
    Column(
        modifier = modifier
            .width(103.dp)
            .noRippleClickable(
                onClick = { onBookItemClick(bookId) },
            ),
    ) {
        AsyncImage(
            model = bookCoverImageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .customShadow(
                    shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
                    color = MillieTheme.colors.black.copy(alpha = 0.07f),
                    blur = 4.dp,
                    offsetY = 4.dp,
                )
                .clip(RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)),
        )

        Spacer(modifier = Modifier.height(10.dp))

        if (isAudiobook) {
            SearchAudioTag(
                voiceActor = voiceActor,
            )
            Spacer(modifier = Modifier.height(2.dp))
        }

        SearchTitleAuthor(
            bookTitle = bookTitle,
            bookAuthor = bookAuthor,
        )

        Spacer(modifier = Modifier.height(1.dp))

        SearchWandokRate(
            rate = completionRate,
            minute = completionTime,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBookItemPreview() {
    SearchBookItem(
        bookId = 1,
        bookCoverImageUrl = "",
        bookTitle = "홍학의 자리",
        bookAuthor = "정해연",
        completionRate = 36,
        completionTime = 533,
        onBookItemClick = {},
        isAudiobook = true,
        voiceActor = "김지윤,박지윤",
    )
}
