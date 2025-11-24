package sopt.org.millie.presentation.bookdetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import sopt.org.millie.R
import sopt.org.millie.presentation.bookdetail.model.BookDataType
import sopt.org.millie.presentation.bookdetail.model.BookSimilarModel
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel
    @Inject
    constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(BookDetailState())
    val uiState: StateFlow<BookDetailState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        loadDummyData()
        // TODO: 서버 연결
    }

    private fun loadDummyData() {
        val dummySimilarBooks = persistentListOf(
            BookSimilarModel(
                bookImage = R.drawable.img_detail_book1,
                bookTitle = "사탄탱고",
                bookAuthor = "크러스너호르커이",
            ),
            BookSimilarModel(
                bookImage = R.drawable.img_detail_book2,
                bookTitle = "고래",
                bookAuthor = "천명권",
            ),
            BookSimilarModel(
                bookImage = R.drawable.img_detail_book3,
                bookTitle = "삼체",
                bookAuthor = "류츠신",
            ),
            BookSimilarModel(
                bookImage = R.drawable.img_detail_book4,
                bookTitle = "홍학의 자리",
                bookAuthor = "정해연",
            ),
            )

        _uiState.update {
            it.copy(similarBooks = dummySimilarBooks)
        }
    }

    fun onBackButtonClicked() {
        // TODO: 네비 연결
    }

    fun onCompletedRateClicked() {
        _uiState.update {
            it.copy(
                selectedType = BookDataType.COMPLETED_RATE,
            )
        }
    }

    fun onAgeGenderClicked() {
        _uiState.update {
            it.copy(
                selectedType = BookDataType.AGE_GENDER,
            )
        }
    }

    fun onImageClicked() {
        _uiState.update {
            it.copy(
                isCompletedGraphChanged = !it.isCompletedGraphChanged,
            )
        }
    }
}
