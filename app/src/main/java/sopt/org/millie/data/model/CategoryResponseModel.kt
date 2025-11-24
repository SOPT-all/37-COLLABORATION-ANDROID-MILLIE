package sopt.org.millie.data.model

import sopt.org.millie.data.dto.response.CategoryResponseDto

data class CategoryResponseModel(
    val categoryId: Long,
    val title: String,
    val description: String,
    val imageUrl: String,
)

fun CategoryResponseDto.toModel() =
    CategoryResponseModel(
        categoryId = categoryId,
        title = title,
        description = description,
        imageUrl = imageUrl,
    )
