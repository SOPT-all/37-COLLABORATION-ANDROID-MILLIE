package sopt.org.millie.presentation.shelf.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.shelf.ShelfScreenRoute

fun NavController.navigateToShelf(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Shelf, navOptions)
}

fun NavGraphBuilder.shelfNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.Shelf> {
        ShelfScreenRoute(paddingValues)
    }
}
