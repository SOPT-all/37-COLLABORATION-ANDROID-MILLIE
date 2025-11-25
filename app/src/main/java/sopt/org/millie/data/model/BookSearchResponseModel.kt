package sopt.org.millie.data.model

import sopt.org.millie.data.dto.response.BannerDto
import sopt.org.millie.data.dto.response.BookListDto
import sopt.org.millie.data.dto.response.BookSearchResponseDto
import kotlin.String

data class BookSearchResponseModel(
    val keyword: String,
    val bookCount: Int,
    val books: List<BookListModel>,
    val banner: BannerModel,
)

fun BookSearchResponseDto.toModel() =
    BookSearchResponseModel(
        keyword = this.keyword,
        bookCount = this.bookCount,
        books = this.books.map { it.toModel() },
        banner = this.banner.toModel(),
    )

data class BookListModel(
    val bookId: Int,
    val bookCoverImageUrl: String,
    val bookTitle: String,
    val bookAuthor: String,
    val completionRate: Int,
    val completionTime: Int,
    val isAudiobook: Boolean,
    val voiceActor: String,
)

fun BookListDto.toModel() =
    BookListModel(
        bookId = this.bookId,
        bookCoverImageUrl = this.bookCoverImageUrl,
        bookTitle = this.bookTitle,
        bookAuthor = this.bookAuthor,
        completionRate = this.completionRate,
        completionTime = this.completionTime,
        isAudiobook = this.isAudiobook,
        voiceActor = this.voiceActor,
    )

data class BannerModel(
    val bannerId: Int,
    val bannerTitle: String,
    val bannerContent: String,
    val bannerImageUrl: String,
)

fun BannerDto.toModel() =
    BannerModel(
        bannerId = this.bannerId,
        bannerTitle = this.bannerTitle,
        bannerContent = this.bannerContent,
        bannerImageUrl = this.bannerImageUrl,
    )
