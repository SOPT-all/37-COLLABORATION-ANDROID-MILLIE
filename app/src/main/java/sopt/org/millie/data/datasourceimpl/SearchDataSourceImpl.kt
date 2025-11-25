package sopt.org.millie.data.datasourceimpl

import sopt.org.millie.core.network.BaseResponse
import sopt.org.millie.data.datasource.SearchDataSource
import sopt.org.millie.data.dto.response.CategoryResponseDto
import sopt.org.millie.data.service.SearchService
import javax.inject.Inject

class SearchDataSourceImpl
    @Inject
    constructor(
    private val searchService: SearchService,
) : SearchDataSource {
    override suspend fun getCategories(): BaseResponse<List<CategoryResponseDto>> =
        searchService.getCategories()
}
