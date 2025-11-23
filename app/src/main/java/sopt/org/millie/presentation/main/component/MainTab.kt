package sopt.org.millie.presentation.main.component

import androidx.annotation.DrawableRes
import sopt.org.millie.R
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.core.navigation.Route

enum class MainTab(
    @DrawableRes val iconRes: Int,
    val route: MainTabRoute,
    val label: String,
) {
    TODAY(
        iconRes = R.drawable.nav_today,
        route = MainTabRoute.Today,
        label = "투데이",
    ),
    WANDOK(
        iconRes = R.drawable.nav_wandok,
        route = MainTabRoute.Wandok,
        label = "완독",
    ),
    SEARCH(
        iconRes = R.drawable.nav_search,
        route = MainTabRoute.Search,
        label = "검색",
    ),
    SHELF(
        iconRes = R.drawable.nav_shelf,
        route = MainTabRoute.Shelf,
        label = "서재",
    ),
    SETTING(
        iconRes = R.drawable.nav_setting,
        route = MainTabRoute.Setting,
        label = "설정",
    ),
    ;

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
