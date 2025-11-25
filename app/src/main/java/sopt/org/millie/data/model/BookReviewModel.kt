package sopt.org.millie.data.model

import androidx.compose.runtime.Immutable
import sopt.org.millie.data.dto.response.BookReviewResponseDto

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

fun BookReviewResponseDto.toModel(): BookReviewModel {
    return BookReviewModel(
        reviewId = this.reviewId,
        bookId = this.bookId,
        reviewerName = this.reviewerName,
        dateOfReview = this.createdDate,
        contentOfReview = this.reviewContent,
        likedNum = this.likeCount,
        isLiked = this.liked,
    )
}
