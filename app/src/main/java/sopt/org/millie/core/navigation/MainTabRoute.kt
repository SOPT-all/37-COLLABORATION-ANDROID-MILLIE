package sopt.org.millie.core.navigation

import kotlinx.serialization.Serializable

interface MainTabRoute : Route {
    @Serializable
    data object Today : MainTabRoute

    @Serializable
    data object Wandok : MainTabRoute

    @Serializable
    data object Search : MainTabRoute

    @Serializable
    data object Shelf : MainTabRoute

    @Serializable
    data object Setting : MainTabRoute
}
