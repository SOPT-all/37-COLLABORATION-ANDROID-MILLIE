package sopt.org.millie.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import kotlinx.collections.immutable.toImmutableList
import sopt.org.millie.presentation.main.component.MainBottomBar
import sopt.org.millie.presentation.main.component.MainTab
import sopt.org.millie.presentation.main.navigation.MainNavigator
import sopt.org.millie.presentation.search.navigation.searchNavGraph
import sopt.org.millie.presentation.setting.navigation.settingNavGraph
import sopt.org.millie.presentation.shelf.navigation.shelfNavGraph
import sopt.org.millie.presentation.today.navigation.todayNavGraph
import sopt.org.millie.presentation.wandok.navigation.wandokNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator,
) {
    val isBottomBarVisible by navigator.isBottomBarVisible.collectAsStateWithLifecycle()
    val currentTab by navigator.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            MainBottomBar(
                visible = isBottomBarVisible,
                tabs = MainTab.entries.toImmutableList(),
                currentTab = currentTab,
                onTabSelected = navigator::navigate,
            )
        },
    ) { paddingValues ->
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            todayNavGraph(paddingValues)
            wandokNavGraph(paddingValues)
            searchNavGraph(paddingValues)
            shelfNavGraph(paddingValues)
            settingNavGraph(paddingValues)
        }
    }
}
