package sopt.org.millie.presentation.home.component.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.home.component.tag.CategoryTag
import sopt.org.millie.presentation.home.constants.HomeConstants

@Composable
fun QuickLinks(
    modifier: Modifier = Modifier,
) {
    val tags = remember { HomeConstants.QUICK_LINK_TAGS }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        HomeTitleItem(
            title = "바로가기",
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 12.dp),
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(horizontal = 24.dp),
        ) {
            items(tags) { tag ->
                CategoryTag(
                    iconRes = tag.iconRes,
                    title = tag.title,
                )
            }
        }
    }
}

@Preview
@Composable
private fun QuickLinksPreview() {
    MillieTheme {
        QuickLinks()
    }
}
