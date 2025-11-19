package sopt.org.millie.presentation.home.component.item

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun RankingItem(
    rank: Int,
    bookTitle: String,
    @DrawableRes rankingIcon: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MillieTheme.colors.background)
            .padding(vertical = 12.dp)
            .padding(start = 27.dp, end = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        RankingInfo(
            rank = rank,
            bookTitle = bookTitle,
            rankingIcon = rankingIcon,
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_result_ranking),
            contentDescription = null,
            tint = MillieTheme.colors.darkGray1,
        )
    }
}

@Composable
private fun RankingInfo(
    rank: Int,
    bookTitle: String,
    @DrawableRes rankingIcon: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        Text(
            text = rank.toString(),
            style = MillieTheme.typography.title.subHead1,
            color = MillieTheme.colors.black,
        )

        Text(
            text = bookTitle,
            style = MillieTheme.typography.body.body3,
            color = MillieTheme.colors.black,
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = rankingIcon),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun RankingItemPreview() {
    MillieTheme {
        RankingItem(
            rank = 2,
            bookTitle = "동화",
            rankingIcon = R.drawable.ic_home_ranking_down,
        )
    }
}
