package sopt.org.millie.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchResponseDto(
    @SerialName("keyword")
    val keyword: String,
    @SerialName("bookCount")
    val bookCount: Int,
    @SerialName("books")
    val books: List<BookListDto>,
    @SerialName("banner")
    val banner: BannerDto,
)

@Serializable
data class BookListDto(
    @SerialName("bookId")
    val bookId: Long,
    @SerialName("bookCoverImageUrl")
    val bookCoverImageUrl: String,
    @SerialName("bookTitle")
    val bookTitle: String,
    @SerialName("bookAuthor")
    val bookAuthor: String,
    @SerialName("completionRate")
    val completionRate: Int,
    @SerialName("completionTime")
    val completionTime: Int,
    @SerialName("isAudiobook")
    val isAudiobook: Boolean,
    @SerialName("voiceActor")
    val voiceActor: String,
)

@Serializable
data class BannerDto(
    @SerialName("bannerId")
    val bannerId: Long,
    @SerialName("bannerTitle")
    val bannerTitle: String,
    @SerialName("bannerContent")
    val bannerContent: String,
    @SerialName("bannerImageUrl")
    val bannerImageUrl: String,
)
