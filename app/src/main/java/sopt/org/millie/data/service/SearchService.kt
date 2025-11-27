package sopt.org.millie.data.service

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.dto.response.BookDetailInformationResponseDto
import sopt.org.millie.data.dto.response.BookReviewResponseDto
import sopt.org.millie.data.dto.response.BookSearchResponseDto
import sopt.org.millie.data.dto.response.CategoryResponseDto

interface SearchService {
    @GET("categories")
    suspend fun getCategories(): BaseResponse<List<CategoryResponseDto>>

    @GET("books")
    suspend fun getBooks(
        @Query("keyword") keyword: String,
    ): BaseResponse<BookSearchResponseDto>

    @GET("books/{bookId}")
    suspend fun getBookDetailInformation(
        @Path("bookId") bookId: Long,
    ): BaseResponse<BookDetailInformationResponseDto>

    @POST("reviews/{reviewId}/like")
    suspend fun postReviewLike(
        @Path("reviewId") reviewId: Long,
    ): BaseResponse<BookReviewResponseDto>
}
