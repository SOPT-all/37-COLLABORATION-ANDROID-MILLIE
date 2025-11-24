package sopt.org.millie.presentation.bookdetail.component.book

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow

@Composable
fun BookDetailBook(
    @DrawableRes bookImage: Int,
    bookTitle: String,
    bookAuthor: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        BookShadow(
            bookImage = bookImage,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = bookTitle,
            color = MillieTheme.colors.darkGray2,
            style = MillieTheme.typography.title.subHead4,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = bookAuthor,
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.body1,
        )
    }
}

@Composable
private fun BookShadow(
    @DrawableRes bookImage: Int,
    modifier: Modifier = Modifier,
) {
    val bookShape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp)

    Box(
        modifier = modifier
            .width(145.dp)
            .height(203.dp)
            .customShadow(shape = bookShape, color = MillieTheme.colors.black.copy(alpha = 0.1f), blur = 6.dp, offsetX = 2.dp, offsetY = 2.dp)
            .customShadow(shape = bookShape, color = MillieTheme.colors.black.copy(alpha = 0.2f), blur = 2.dp),
    ) {
        Image(
            painter = painterResource(id = bookImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = bookShape),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp),
        ) {
            BookDetailBook(
                bookImage = R.drawable.img_detail_book1,
                bookTitle = "도서 제목",
                bookAuthor = "저자명",
            )
        }
    }
}
