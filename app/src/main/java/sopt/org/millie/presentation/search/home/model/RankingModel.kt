package sopt.org.millie.presentation.search.home.model

import androidx.annotation.DrawableRes

data class RankingModel(
    val rank: Int,
    val bookTitle: String,
    @DrawableRes val rankingIcon: Int,
)
