package sopt.org.millie.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sopt.org.millie.data.repository.BookDetailRepository
import sopt.org.millie.data.repository.SearchRepository
import sopt.org.millie.data.repositoryimpl.BookDetailRepositoryImpl
import sopt.org.millie.data.repositoryimpl.SearchRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl,
    ): SearchRepository

    @Binds
    @Singleton
    abstract fun bindsBookDetailRepository(
        bookDetailRepositoryImpl: BookDetailRepositoryImpl,
    ): BookDetailRepository
}
