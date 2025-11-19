package sopt.org.millie.presentation.search.component.library

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun LibraryItem(
    @DrawableRes imgRes: Int,
    bookTitle: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imgRes),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(width = 65.dp, height = 66.dp),
        )

        Spacer(modifier = Modifier.height(11.dp))

        Text(
            text = bookTitle,
            color = MillieTheme.colors.gray4,
            style = MillieTheme.typography.body.subBody2,
        )

        Text(
            text = "서재",
            color = MillieTheme.colors.gray4,
            style = MillieTheme.typography.body.subBody2,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LibraryItemPreview() {
    LibraryItem(
        imgRes = R.drawable.img_search_library_1,
        bookTitle = "홍학의 자리",
    )
}
