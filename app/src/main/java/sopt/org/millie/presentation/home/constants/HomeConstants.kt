package sopt.org.millie.presentation.home.constants

import sopt.org.millie.R

object HomeConstants {
    val QUICK_LINK_TAGS = listOf(
        QuickLinkItem(R.drawable.ic_home_ranking, "밀리 랭킹"),
        QuickLinkItem(R.drawable.ic_home_newbook, "새로 들어온 책"),
        QuickLinkItem(R.drawable.ic_home_calendar, "공개 예정"),
    )

    val HOME_TABS = listOf("카테고리", "웹툰/웹소설", "오디오", "작가", "컬렉션")

    const val DEFAULT_TAB = "카테고리"

    data class QuickLinkItem(
        val iconRes: Int,
        val title: String,
    )
}
