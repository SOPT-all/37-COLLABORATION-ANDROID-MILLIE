package sopt.org.millie.data.repositoryimpl

import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.core.util.suspendRunCatching
import sopt.org.millie.data.datasource.SearchDataSource
import sopt.org.millie.data.model.BookDetailModel
import sopt.org.millie.data.model.BookSearchResponseModel
import sopt.org.millie.data.model.CategoryResponseModel
import sopt.org.millie.data.model.toModel
import sopt.org.millie.data.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl
    @Inject
    constructor(
        private val searchDataSource: SearchDataSource,
) : SearchRepository {
    override suspend fun getCategories(): Result<List<CategoryResponseModel>> =
        runCatching {
            searchDataSource.getCategories().data?.map { it.toModel() } ?: persistentListOf()
        }

    override suspend fun getBooks(keyword: String): Result<BookSearchResponseModel> =
        suspendRunCatching {
            searchDataSource.getBooks(keyword).data?.toModel() ?: throw IllegalArgumentException()
        }

    override suspend fun getBookDetailInformation(bookId: Long): Result<BookDetailModel> {
        return suspendRunCatching {
            val response = searchDataSource.getBookDetailInformation(bookId)
            response.data?.toModel() ?: throw IllegalArgumentException("response data is null")
        }
    }
}
