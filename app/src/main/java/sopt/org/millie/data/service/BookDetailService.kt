package sopt.org.millie.data.service

import retrofit2.http.GET
import retrofit2.http.Path
import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.dto.response.BookDetailInformationResponseDto

interface BookDetailService {
    @GET("books/{bookId}")
    suspend fun getBookDetailInformation(
        @Path("bookId") bookId: Long,
    ): BaseResponse<BookDetailInformationResponseDto>
}
