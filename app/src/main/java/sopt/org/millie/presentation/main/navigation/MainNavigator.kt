package sopt.org.millie.presentation.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.main.component.MainTab

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
        navController.navigate(tab.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = false
        }
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): MainNavigator = remember(navController) {
    MainNavigator(navController, coroutineScope)
}
