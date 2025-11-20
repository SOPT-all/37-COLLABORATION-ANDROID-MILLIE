package sopt.org.millie.presentation.bookdetail.model

import androidx.compose.runtime.Immutable

@Immutable
data class BookReviewModel(
    val username: String,
    val dateOfReview: String,
    val contentOfReview: String,
    val likedNum: Int,
)
