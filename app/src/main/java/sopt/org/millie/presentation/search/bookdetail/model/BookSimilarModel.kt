package sopt.org.millie.presentation.search.bookdetail.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import sopt.org.millie.R

@Immutable
data class BookSimilarModel(
    @DrawableRes val bookImage: Int = R.drawable.img_detail_book1,
    val bookTitle: String = "",
    val bookAuthor: String = "",
)
