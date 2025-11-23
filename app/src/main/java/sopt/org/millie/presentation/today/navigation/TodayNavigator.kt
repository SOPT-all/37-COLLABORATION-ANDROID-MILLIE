package sopt.org.millie.presentation.today.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.today.TodayScreenRoute

fun NavController.navigateToToday(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Today, navOptions)
}

fun NavGraphBuilder.todayNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.Today> {
        TodayScreenRoute(paddingValues)
    }
}
