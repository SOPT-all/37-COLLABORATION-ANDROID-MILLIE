package sopt.org.millie.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponseDto(
    @SerialName("categoryId")
    val categoryId: Long,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageUrl")
    val imageUrl: String,
)
