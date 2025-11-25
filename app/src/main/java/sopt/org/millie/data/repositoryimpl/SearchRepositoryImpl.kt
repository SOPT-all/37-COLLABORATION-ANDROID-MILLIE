package sopt.org.millie.data.repositoryimpl

import sopt.org.millie.core.util.suspendRunCatching
import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.core.util.suspendRunCatching
import sopt.org.millie.data.datasource.SearchDataSource
import sopt.org.millie.data.model.BookDetailModel
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
        suspendRunCatching {
            searchDataSource.getCategories().data!!.map { it.toModel() }
        }

    override suspend fun getBookDetailInformation(bookId: Long): Result<BookDetailModel> {
        return suspendRunCatching {
            val response = searchDataSource.getBookDetailInformation(bookId)
            response.data?.toModel() ?: throw IllegalArgumentException("response data is null")
        }
    }
}
