package sopt.org.millie.presentation.bookdetail.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class BookSimilarModel(
    @DrawableRes val bookImage: Int,
    val bookTitle: String,
    val bookAuthor: String,
)
