package sopt.org.millie.data.model

import sopt.org.millie.data.dto.response.BannerDto
import sopt.org.millie.data.dto.response.BookListDto
import sopt.org.millie.data.dto.response.BookSearchResponseDto
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBannerModel
import sopt.org.millie.presentation.search.searchresult.book.model.SearchBookModel
import kotlin.String

data class BookSearchResponseModel(
    val keyword: String,
    val bookCount: Int,
    val books: List<SearchBookModel>,
    val banner: SearchBannerModel,
)

fun BookSearchResponseDto.toModel() =
    BookSearchResponseModel(
        keyword = this.keyword,
        bookCount = this.bookCount,
        books = this.books.map { it.toModel() },
        banner = this.banner.toModel(),
    )

fun BookListDto.toModel() =
    SearchBookModel(
        bookId = this.bookId,
        bookCoverImageUrl = this.bookCoverImageUrl,
        bookTitle = this.bookTitle,
        bookAuthor = this.bookAuthor,
        completionRate = this.completionRate,
        completionTime = this.completionTime,
        isAudiobook = this.isAudiobook,
        voiceActor = this.voiceActor,
    )

fun BannerDto.toModel() =
    SearchBannerModel(
        bannerId = this.bannerId,
        bannerTitle = this.bannerTitle,
        bannerContent = this.bannerContent,
        bannerImageUrl = this.bannerImageUrl,
    )
