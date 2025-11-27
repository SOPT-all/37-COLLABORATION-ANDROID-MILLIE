package sopt.org.millie.presentation.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import sopt.org.millie.core.navigation.MainTabRoute
import sopt.org.millie.presentation.search.bookdetail.BookDetailRoute
import sopt.org.millie.presentation.search.home.HomeRoute
import sopt.org.millie.presentation.search.searchresult.SearchRoute

@Serializable
object SearchHomeRoute

// 검색 결과 네비 라우트 정의
@Serializable
data class SearchResultRoute(
    val keyword: String,
)

// 책 상세 네비 라우트 정의
@Serializable
data class SearchBookDetailRoute(
    val bookId: Long,
)

fun NavController.navigateToSearch(
    navOptions: NavOptions,
) {
    navigate(MainTabRoute.Search, navOptions)
}

// 검색 결과 화면 네비게이션
fun NavController.navigateToSearchResult(
    keyword: String,
    navOptions: NavOptions? = null,
) {
    navigate(SearchResultRoute(keyword), navOptions)
}

// 책 상세 화면 네비게이션
fun NavController.navigateToBookDetail(
    bookId: Long,
    navOptions: NavOptions? = null,
) {
    navigate(SearchBookDetailRoute(bookId), navOptions)
}

fun NavGraphBuilder.searchNavGraph(
    navController: NavController,
    paddingValues: PaddingValues,
) {
    navigation<MainTabRoute.Search>(
        startDestination = SearchHomeRoute,
    ) {
        // 1. 검색 홈 화면
        composable<SearchHomeRoute> {
            HomeRoute(
                paddingValues = paddingValues,
                onSearchAction = navController::navigateToSearchResult,
            )
        }

        // 2. 검색 결과 화면
        composable<SearchResultRoute> {
            SearchRoute(
                paddingValues = paddingValues,
                navigateUp = navController::navigateUp,
                navigateToBookDetail = navController::navigateToBookDetail,
            )
        }

        // 3. 책 상세 화면
        composable<SearchBookDetailRoute> {
            BookDetailRoute(
                paddingValues = paddingValues,
                navigateUp = navController::navigateUp,
            )
        }
    }
}
