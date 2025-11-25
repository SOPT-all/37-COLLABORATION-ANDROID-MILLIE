package sopt.org.millie.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import sopt.org.millie.data.service.BookDetailService
import sopt.org.millie.data.service.SearchService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit): SearchService = retrofit.create(SearchService::class.java)

    @Provides
    @Singleton
    fun provideBookDetailService(retrofit: Retrofit): BookDetailService = retrofit.create(BookDetailService::class.java)
}
