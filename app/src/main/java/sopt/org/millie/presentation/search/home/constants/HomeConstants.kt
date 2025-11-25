package sopt.org.millie.presentation.search.home.constants

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.R

@Immutable
object HomeConstants {
    val QUICK_LINK_TAGS = persistentListOf(
        QuickLinkItem(R.drawable.ic_home_ranking, "밀리 랭킹"),
        QuickLinkItem(R.drawable.ic_home_newbook, "새로 들어온 책"),
        QuickLinkItem(R.drawable.ic_home_calendar, "공개 예정"),
    )

    val HOME_TABS = persistentListOf("카테고리", "웹툰/웹소설", "오디오", "작가", "컬렉션")

    const val DEFAULT_TAB = "카테고리"

    data class QuickLinkItem(
        @DrawableRes val iconRes: Int,
        val title: String,
    )
}
