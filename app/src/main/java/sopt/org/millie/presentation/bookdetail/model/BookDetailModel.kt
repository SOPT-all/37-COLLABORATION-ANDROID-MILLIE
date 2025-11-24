package sopt.org.millie.presentation.bookdetail.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class BookDetailModel(
    val bookId: Long = 0,
    val bookCoverImageUrl: String = "",
    val bookTitle: String = "",
    val bookAuthor: String = "",
    val bookType: String = "",
    val publishedDate: String = "",
    val bookRate: Float = 0f,
    val totalReviewCount: Int = 0,
    val completionRate: Int = 0,
    val bookDescription: String = "",
    val reviews: ImmutableList<BookReviewModel> = persistentListOf(),
)
