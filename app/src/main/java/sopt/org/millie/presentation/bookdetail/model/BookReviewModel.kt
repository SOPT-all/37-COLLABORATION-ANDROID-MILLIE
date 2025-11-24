package sopt.org.millie.presentation.bookdetail.model

import androidx.compose.runtime.Immutable

@Immutable
data class BookReviewModel(
    val reviewId: Long,
    val bookId: Long,
    val reviewerName: String,
    val dateOfReview: String,
    val contentOfReview: String,
    val likedNum: Int,
    val isLiked: Boolean,
)
