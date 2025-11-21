package sopt.org.millie.presentation.bookdetail.component.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun BookDetailTag(
    tagBackgroundColor: Color,
    tagText: String,
    tagTextColor: Color,
    onTagClick: () -> Unit,
    modifier: Modifier = Modifier,
    tagBorderColor: Color = Color.Transparent,
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100.dp))
            .background(color = tagBackgroundColor)
            .border(width = 1.dp, color = tagBorderColor, shape = RoundedCornerShape(100.dp))
            .noRippleClickable(onClick = onTagClick)
            .padding(horizontal = 16.dp, vertical = 6.dp),
    ) {
        Text(
            text = tagText,
            color = tagTextColor,
            style = MillieTheme.typography.body.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        Column {
            BookDetailTag(
                tagBackgroundColor = MillieTheme.colors.black,
                tagText = "완독지수",
                tagTextColor = MillieTheme.colors.white,
                onTagClick = {},
            )

            BookDetailTag(
                tagBackgroundColor = MillieTheme.colors.white,
                tagText = "완독지수",
                tagTextColor = MillieTheme.colors.black,
                tagBorderColor = MillieTheme.colors.lightGray2,
                onTagClick = {},
            )
        }
    }
}
