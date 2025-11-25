package sopt.org.millie.data.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import sopt.org.millie.data.dto.response.BookDetailInformationResponseDto

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

fun BookDetailInformationResponseDto.toModel(): BookDetailModel {
    return BookDetailModel(
        bookId = this.bookId,
        bookCoverImageUrl = this.bookCoverImageUrl,
        bookTitle = this.bookTitle,
        bookAuthor = this.bookAuthor,
        bookType = this.bookType,
        publishedDate = this.publishedDate,
        bookRate = this.bookRate,
        totalReviewCount = this.totalReviewCount,
        completionRate = this.completionRate,
        bookDescription = this.bookDescription,
        reviews = this.reviews.map { it.toModel() }.toPersistentList(),
    )
}
