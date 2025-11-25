package sopt.org.millie.presentation.search.bookdetail.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class BookDetailModel(
    val bookId: Long,
    val bookCoverImageUrl: String,
    val bookTitle: String,
    val bookAuthor: String,
    val bookType: String,
    val publishedDate: String,
    val bookRate: Float,
    val totalReviewCount: Int,
    val completionRate: Int,
    val bookDescription: String,
    val reviews: ImmutableList<BookReviewModel> = persistentListOf(),
)
