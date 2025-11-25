package sopt.org.millie.data.model

import sopt.org.millie.data.dto.response.BannerDto
import sopt.org.millie.data.dto.response.BookListDto
import sopt.org.millie.data.dto.response.BookSearchResponseDto

data class BookSearchResponseModel(
    val keyword: String,
    val bookCount: Int,
    val books: List<BookListDto>,
    val banner: BannerDto,
)

fun BookSearchResponseDto.toModel() =
    BookSearchResponseModel(
        keyword = this.keyword,
        bookCount = this.bookCount,
        books = this.books,
        banner = this.banner,
    )
