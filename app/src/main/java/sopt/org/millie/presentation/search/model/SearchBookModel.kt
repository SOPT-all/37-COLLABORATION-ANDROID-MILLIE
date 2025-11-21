package sopt.org.millie.presentation.search.model

data class SearchBookModel(
    val imageUrl: String,
    val reader: String,
    val title: String,
    val author: String,
    val rate: Int,
    val minute: Int,
    val isAudioEnabled: Boolean = true,
)
