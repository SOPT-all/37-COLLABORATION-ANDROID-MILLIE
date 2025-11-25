package sopt.org.millie.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchRequestDto(
    @SerialName("keyword")
    val keyword: String,
)
