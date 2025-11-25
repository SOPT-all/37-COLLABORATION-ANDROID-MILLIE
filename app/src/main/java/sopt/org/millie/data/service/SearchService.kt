package sopt.org.millie.data.service

import retrofit2.http.GET
import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.dto.response.CategoryResponseDto

interface SearchService {
    @GET("categories")
    suspend fun getCategories(): BaseResponse<List<CategoryResponseDto>>
}
