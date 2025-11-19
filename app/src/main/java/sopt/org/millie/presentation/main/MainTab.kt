package sopt.org.millie.presentation.main

import androidx.annotation.DrawableRes
import sopt.org.millie.R
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.core.navigation.Route

enum class MainTab(
    @DrawableRes val iconRes: Int,
    val route: MainTabRoute,
    val label: String
) {
    TODAY(
        iconRes = R.drawable.nav_today,
        route = Today,
        label = "오늘"
    ),
    WANDOK(
        iconRes = R.drawable.nav_wandok,
        route = Wandok,
        label = "완독"
    ),
    SEARCH(
        iconRes = R.drawable.nav_search,
        route = Search,
        label = "검색"
    ),
    SHELF(
        iconRes = R.drawable.nav_shelf,
        route = Shelf,
        label = "서재"
    ),
    SETTING(
        iconRes = R.drawable.nav_setting,
        route = Setting,
        label = "설정"
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
