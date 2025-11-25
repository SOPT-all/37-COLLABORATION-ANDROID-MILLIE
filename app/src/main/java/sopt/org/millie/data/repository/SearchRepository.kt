package sopt.org.millie.data.repository

import sopt.org.millie.data.model.BookDetailModel
import sopt.org.millie.data.model.CategoryResponseModel

interface SearchRepository {
    suspend fun getCategories(): Result<List<CategoryResponseModel>>

    suspend fun getBookDetailInformation(bookId: Long): Result<BookDetailModel>
}
