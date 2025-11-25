package sopt.org.millie.data.repository

import sopt.org.millie.data.model.BookSearchResponseModel
import sopt.org.millie.data.model.CategoryResponseModel

interface SearchRepository {
    suspend fun getCategories(): Result<List<CategoryResponseModel>>

    suspend fun getBooks(keyword: String): Result<BookSearchResponseModel>
}
