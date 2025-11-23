package sopt.org.millie.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.search.navigateToSearch
import sopt.org.millie.presentation.setting.navigateToSetting
import sopt.org.millie.presentation.shelf.navigateToShelf
import sopt.org.millie.presentation.today.navigateToToday
import sopt.org.millie.presentation.wandok.navigateToWandok

class MainNavigator(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination = MainTabRoute.Search

    private val currentDestination = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )

    val currentTab: StateFlow<MainTab?> = currentDestination
        .map { destination ->
            MainTab.find { tab ->
                destination?.hasRoute(tab::class) == true ||
                    destination?.parent?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentDestination
        .map { destination ->
            MainTab.entries.any { tab ->
                destination?.hasRoute(tab.route::class) == true ||
                    destination?.parent?.hasRoute(tab.route::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = true,
        )

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.TODAY -> navController.navigateToToday(navOptions)
            MainTab.WANDOK -> navController.navigateToWandok(navOptions)
            MainTab.SEARCH -> navController.navigateToSearch(navOptions)
            MainTab.SHELF -> navController.navigateToShelf(navOptions)
            MainTab.SETTING -> navController.navigateToSetting(navOptions)
        }
    }

    fun navigateToSearchField() {}

    fun navigateUp() {
        navController.navigateUp()
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): MainNavigator = remember(navController) {
    MainNavigator(navController, coroutineScope)
}
