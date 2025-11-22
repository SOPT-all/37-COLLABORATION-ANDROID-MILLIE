package sopt.org.millie.presentation.search.model
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class SearchLibraryModel(
    @DrawableRes val imgRes: Int,
    val bookTitle: String,
)
