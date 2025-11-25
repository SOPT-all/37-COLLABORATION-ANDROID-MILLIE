package sopt.org.millie.presentation.setting.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.setting.SettingScreenRoute

fun NavController.navigateToSetting(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Setting, navOptions)
}

fun NavGraphBuilder.settingNavGraph(
    paddingValues: PaddingValues,
) {
    composable<MainTabRoute.Setting> {
        SettingScreenRoute(paddingValues)
    }
}
