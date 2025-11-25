package sopt.org.millie.data.repositoryimpl

import kotlinx.collections.immutable.persistentListOf
import sopt.org.millie.data.datasource.SearchDataSource
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
}
