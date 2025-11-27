package sopt.org.millie.presentation.search.home.component.item

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.search.home.model.RankingModel

@Composable
fun RankingItem(
    rankingList: ImmutableList<RankingModel>,
    modifier: Modifier = Modifier,
) {
    var currentIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentIndex = (currentIndex + 1) % rankingList.size
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MillieTheme.colors.background)
            .padding(vertical = 12.dp)
            .padding(start = 27.dp, end = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        AnimatedContent(
            targetState = rankingList[currentIndex],
            transitionSpec = {
                slideInVertically(initialOffsetY = { it }) togetherWith
                    slideOutVertically(targetOffsetY = { -it })
            },
            label = "ranking_animation",
        ) { ranking ->
            RankingInfo(
                rank = ranking.rank,
                bookTitle = ranking.bookTitle,
                rankingIcon = ranking.rankingIcon,
            )
        }
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

@Preview(showBackground = true)
@Composable
private fun RankingItemPreview() {
    MillieTheme {
        RankingItem(
            rankingList = kotlinx.collections.immutable.persistentListOf(
                RankingModel(
                    rank = 1,
                    bookTitle = "동화",
                    rankingIcon = R.drawable.ic_home_ranking_up,
                ),
                RankingModel(
                    rank = 2,
                    bookTitle = "소설",
                    rankingIcon = R.drawable.ic_home_ranking_down,
                ),
                RankingModel(
                    rank = 3,
                    bookTitle = "시집",
                    rankingIcon = R.drawable.ic_home_ranking_up,
                ),
            ),
        )
    }
}
