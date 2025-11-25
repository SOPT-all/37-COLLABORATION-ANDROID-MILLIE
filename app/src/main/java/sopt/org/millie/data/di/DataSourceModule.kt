package sopt.org.millie.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sopt.org.millie.data.datasource.BookDetailDataSource
import sopt.org.millie.data.datasource.SearchDataSource
import sopt.org.millie.data.datasourceimpl.BookDetailDataSourceImpl
import sopt.org.millie.data.datasourceimpl.SearchDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindSearchDataSource(
        searchDataSourceImpl: SearchDataSourceImpl,
    ): SearchDataSource

    @Binds
    @Singleton
    abstract fun bindBookDetailDataSource(
        bookDetailDataSourceImpl: BookDetailDataSourceImpl,
    ): BookDetailDataSource
}
