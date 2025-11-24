package sopt.org.millie.presentation.bookdetail

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.presentation.bookdetail.model.BookDataType
import sopt.org.millie.presentation.bookdetail.model.BookDetailModel
import sopt.org.millie.presentation.bookdetail.model.BookSimilarModel

data class BookDetailState(
    val bookDetailUiModel: BookDetailModel = BookDetailModel(),
    val isCompletedGraphChanged: Boolean = true,
    val selectedType: BookDataType = BookDataType.COMPLETED_RATE,
    val similarBooks: ImmutableList<BookSimilarModel> = persistentListOf(),
)
