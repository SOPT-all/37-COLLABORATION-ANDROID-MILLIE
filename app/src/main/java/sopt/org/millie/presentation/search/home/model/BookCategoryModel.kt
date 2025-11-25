package sopt.org.millie.presentation.search.home.model

import androidx.compose.runtime.Immutable

@Immutable
data class BookCategoryModel(
    val categoryId: Long,
    val title: String,
    val description: String,
    val imageUrl: String,
)
