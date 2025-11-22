package sopt.org.millie.presentation.search.model
import androidx.compose.runtime.Immutable

@Immutable
data class SearchBannerModel(
    val bannerTitle: String,
    val bannerContent: String,
    val bannerUrl: String,
)
