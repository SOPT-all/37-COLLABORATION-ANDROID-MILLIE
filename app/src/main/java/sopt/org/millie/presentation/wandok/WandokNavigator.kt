package sopt.org.millie.presentation.wandok

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import sopt.org.millie.core.navigation.MainTabRoute

fun NavController.navigateToWandok(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Wandok, navOptions)
}

fun NavGraphBuilder.wandokNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.Wandok> {
        WandokScreenRoute(paddingValues)
    }
}
