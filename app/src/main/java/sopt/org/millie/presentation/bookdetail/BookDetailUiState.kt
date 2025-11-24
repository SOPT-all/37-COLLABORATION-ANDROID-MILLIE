package sopt.org.millie.presentation.bookdetail

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.presentation.bookdetail.model.BookDataType
import sopt.org.millie.presentation.bookdetail.model.BookDetailModel
import sopt.org.millie.presentation.bookdetail.model.BookSimilarModel

@Immutable
data class BookDetailUiState(
    val bookDetailUiModel: BookDetailModel = BookDetailModel(bookId = 0, bookCoverImageUrl = "", bookTitle = "", bookAuthor = "", bookType = "", publishedDate = "", bookRate = 0f, totalReviewCount = 0, completionRate = 0, bookDescription = ""),
    val isCompletedGraphChanged: Boolean = true,
    val selectedType: BookDataType = BookDataType.COMPLETED_RATE,
    val similarBooks: ImmutableList<BookSimilarModel> = persistentListOf(),
)
