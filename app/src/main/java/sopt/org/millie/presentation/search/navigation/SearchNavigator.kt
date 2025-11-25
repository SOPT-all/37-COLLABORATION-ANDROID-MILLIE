package sopt.org.millie.presentation.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.search.home.HomeRoute

@Serializable
object SearchHomeRoute

// 검색 결과 네비 라우트 정의

// 책 상세 네비 라우트 정의

fun NavController.navigateToSearch(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Search, navOptions)
}

// 검색 결과 화면 네비게이션

// 책 상세 화면 네비게이션

fun NavGraphBuilder.searchNavGraph(
    paddingValues: PaddingValues,
) {
    navigation<MainTabRoute.Search>(
        startDestination = SearchHomeRoute,
    ) {
        // 1. 검색 홈 화면
        composable<SearchHomeRoute> {
            HomeRoute(paddingValues = paddingValues)
        }

        // 2. 검색 결과 화면

        // 3. 책 상세 화면
    }
}
