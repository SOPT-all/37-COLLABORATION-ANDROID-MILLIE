package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun MillieTabbar(
    tab: MutableList<String>,
    horizontalPadding: Dp = 36.dp,
    onTabSelected: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    defaultSelectedTab: String = tab.first(),
) {
    var selectedTab by remember { mutableStateOf(defaultSelectedTab) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        tab.forEach { title ->
            MillieTabbarText(
                title = title,
                selected = selectedTab == title,
                onClick = {
                    selectedTab = title
                    onTabSelected(title)
                },
            )
        }
    }
}

@Composable
private fun MillieTabbarText(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .noRippleClickable(onClick = onClick),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 8.dp),
            color = MillieTheme.colors.black,
            style = if (selected) MillieTheme.typography.title.subHead4 else MillieTheme.typography.body.body3,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = if (selected) MillieTheme.colors.black else MillieTheme.colors.white),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MillieTabbarTextPreview() {
    MillieTheme {
        MillieTabbar(
            tab = mutableListOf("도서", "밀리로드", "포스트", "서재"),
            horizontalPadding = 36.dp,
            onTabSelected = {},
        )
    }
}
