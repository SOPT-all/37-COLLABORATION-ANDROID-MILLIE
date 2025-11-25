package sopt.org.millie.data.datasourceimpl

import sopt.org.millie.data.datasource.BookDetailDataSource
import sopt.org.millie.data.service.BookDetailService
import javax.inject.Inject


class BookDetailDataSourceImpl @Inject constructor(
    private val bookDetailService: BookDetailService
): BookDetailDataSource {
    override suspend fun getBookDetailInformation(bookId: Long) =
        bookDetailService.getBookDetailInformation(bookId)
}
