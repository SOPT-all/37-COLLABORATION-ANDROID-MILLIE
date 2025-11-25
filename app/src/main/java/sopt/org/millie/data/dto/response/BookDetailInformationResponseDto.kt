package sopt.org.millie.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailInformationResponseDto(
    @SerialName("bookId")
    val bookId: Long,
    @SerialName("bookCoverImageUrl")
    val bookCoverImageUrl: String,
    @SerialName("bookTitle")
    val bookTitle: String,
    @SerialName("bookAuthor")
    val bookAuthor: String,
    @SerialName("bookType")
    val bookType: String,
    @SerialName("publishedDate")
    val publishedDate: String,
    @SerialName("bookRate")
    val bookRate: Float,
    @SerialName("totalReviewCount")
    val totalReviewCount: Int,
    @SerialName("completionRate")
    val completionRate: Int,
    @SerialName("bookDescription")
    val bookDescription: String,
    @SerialName("reviews")
    val reviews: List<BookReviewResponseDto>,
)
