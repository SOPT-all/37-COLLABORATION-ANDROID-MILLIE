package sopt.org.millie.presentation.search.searchresult.book.model

import androidx.compose.runtime.Immutable

@Immutable
data class SearchBookModel(
    val bookId: Long,
    val bookCoverImageUrl: String,
    val bookTitle: String,
    val bookAuthor: String,
    val completionRate: Int,
    val completionTime: Int,
    val isAudiobook: Boolean = false,
    val voiceActor: String? = "",
)
