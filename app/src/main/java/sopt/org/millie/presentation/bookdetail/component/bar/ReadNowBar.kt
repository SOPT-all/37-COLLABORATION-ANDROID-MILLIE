package sopt.org.millie.presentation.bookdetail.component.bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.button.MillieButton
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun ReadNowBar(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = MillieTheme.colors.lightGray2,
        )

        ReadNowBarContent(
            onButtonClick = onButtonClick,
        )
    }
}

@Composable
private fun ReadNowBarContent(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(9.dp),
    ) {
        ReadNowBarItem(
            icon = R.drawable.ic_detail_store,
            label = "담기",
        )

        ReadNowBarItem(
            icon = R.drawable.ic_detail_download,
            label = "다운로드",
        )

        MillieButton(
            onClick = onButtonClick,
            buttonBackgroundColor = MillieTheme.colors.darkGray2,
            buttonText = "바로 읽기",
            buttonTextStyle = MillieTheme.typography.body.body3,
            buttonTextColor = MillieTheme.colors.white,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun ReadNowBarItem(
    @DrawableRes icon: Int,
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp),
        )

        Text(
            text = label,
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.caption2,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        ReadNowBar(
            onButtonClick = {},
        )
    }
}
