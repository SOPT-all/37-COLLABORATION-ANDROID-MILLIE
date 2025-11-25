package sopt.org.millie.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponseDto(
    @SerialName("reviewId")
    val reviewId: Long,
    @SerialName("bookId")
    val bookId: Long,
    @SerialName("reviewerName")
    val reviewerName: String,
    @SerialName("createdDate")
    val createdDate: String,
    @SerialName("reviewContent")
    val reviewContent: String,
    @SerialName("liked")
    val liked: Boolean,
    @SerialName("likeCount")
    val likeCount: Int,
)
