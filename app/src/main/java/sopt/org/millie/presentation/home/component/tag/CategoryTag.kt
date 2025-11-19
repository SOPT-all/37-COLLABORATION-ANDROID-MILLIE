package sopt.org.millie.presentation.home.component.tag

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun CategoryTag(
    @DrawableRes iconRes: Int,
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier,
    ) {
        CategoryIconBox(iconRes = iconRes)

        Text(
            text = title,
            style = MillieTheme.typography.body.body2,
            color = MillieTheme.colors.black,
        )
    }
}

@Composable
private fun CategoryIconBox(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                color = MillieTheme.colors.lightGray1,
                shape = CircleShape,
            )
            .padding(7.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconRes),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = MillieTheme.colors.gray3,
        )
    }
}

@Preview
@Composable
private fun CategoryTagPreview() {
    MillieTheme {
        CategoryTag(
            iconRes = sopt.org.millie.R.drawable.ic_home_calendar,
            title = "공개 예정",
        )
    }
}
