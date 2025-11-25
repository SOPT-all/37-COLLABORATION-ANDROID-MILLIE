package sopt.org.millie.data.repository

import sopt.org.millie.data.model.BookDetailModel

interface BookDetailRepository {
    suspend fun getBookDetailInformation(bookId: Long): Result<BookDetailModel>
}
