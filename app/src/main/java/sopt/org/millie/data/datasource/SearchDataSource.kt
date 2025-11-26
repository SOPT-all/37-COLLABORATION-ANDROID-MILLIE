package sopt.org.millie.data.datasource

import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.dto.response.BookDetailInformationResponseDto
import sopt.org.millie.data.dto.response.BookSearchResponseDto
import sopt.org.millie.data.dto.response.CategoryResponseDto

interface SearchDataSource {
    suspend fun getCategories(): BaseResponse<List<CategoryResponseDto>>

    suspend fun getBooks(keyword: String): BaseResponse<BookSearchResponseDto>

    suspend fun getBookDetailInformation(bookId: Long): BaseResponse<BookDetailInformationResponseDto>
}
