package sopt.org.millie.data.datasource

import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.dto.response.BookDetailInformationResponseDto

interface BookDetailDataSource {
    suspend fun getBookDetailInformation(bookId: Long): BaseResponse<BookDetailInformationResponseDto>
}
