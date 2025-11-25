package sopt.org.millie.data.repositoryimpl

import sopt.org.millie.data.datasource.BookDetailDataSource
import sopt.org.millie.data.model.BookDetailModel
import sopt.org.millie.data.model.toModel
import sopt.org.millie.data.repository.BookDetailRepository
import javax.inject.Inject

class BookDetailRepositoryImpl
    @Inject
    constructor(
    private val bookDetailDataSource: BookDetailDataSource,
) : BookDetailRepository {
    override suspend fun getBookDetailInformation(bookId: Long): Result<BookDetailModel> {
        return runCatching {
           val response = bookDetailDataSource.getBookDetailInformation(bookId)
            response.data?.toModel() ?: throw IllegalArgumentException("response data is null")
        }
    }
}
