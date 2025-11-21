package sopt.org.millie.presentation.search.model

import androidx.annotation.DrawableRes

data class SearchLibraryModel(
    @DrawableRes val imgRes: Int,
    val bookTitle: String,
)
