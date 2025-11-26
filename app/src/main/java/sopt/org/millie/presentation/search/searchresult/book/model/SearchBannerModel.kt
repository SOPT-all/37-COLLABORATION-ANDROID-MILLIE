package sopt.org.millie.presentation.search.searchresult.book.model

import androidx.compose.runtime.Immutable

@Immutable
data class SearchBannerModel(
    val bannerId: Long,
    val bannerTitle: String,
    val bannerContent: String,
    val bannerImageUrl: String,
)
