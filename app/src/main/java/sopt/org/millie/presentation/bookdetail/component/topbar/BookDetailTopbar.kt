package sopt.org.millie.presentation.bookdetail.component.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun BookDetailTopbar(
    bookDetailTopbarBackgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = bookDetailTopbarBackgroundColor),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_back),
            contentDescription = "back",
            tint = Color.Unspecified,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_heart),
            contentDescription = "heart",
            tint = Color.Unspecified,
        )

        Spacer(modifier = Modifier.width(6.dp))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_more),
            contentDescription = "more",
            tint = Color.Unspecified,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDetailTopbar(
            bookDetailTopbarBackgroundColor = MillieTheme.colors.white,
        )
    }
}
