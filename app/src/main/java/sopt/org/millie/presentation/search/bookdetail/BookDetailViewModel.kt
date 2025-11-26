package sopt.org.millie.presentation.search.bookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.millie.R
import sopt.org.millie.data.model.BookReviewModel
import sopt.org.millie.data.repository.SearchRepository
import sopt.org.millie.presentation.search.bookdetail.BookDetailUiState
import sopt.org.millie.presentation.search.bookdetail.model.BookDataType
import sopt.org.millie.presentation.search.bookdetail.model.BookSimilarModel
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel
@Inject
constructor(
    private val searchRepository: SearchRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(BookDetailUiState())
    private val bookId: Long = checkNotNull(savedStateHandle["bookId"])
    val uiState: StateFlow<BookDetailUiState> = _uiState.asStateFlow()

    init {
        loadData(bookId)
    }

    private fun loadData(bookId: Long) {
        loadDummyData()

        viewModelScope.launch {
            searchRepository.getBookDetailInformation(bookId)
                .onSuccess { bookDetailModel ->
                    _uiState.update {
                        it.copy(bookDetailUiModel = bookDetailModel)
                    }
                }
        }
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

    fun onReviewLikeClicked(reviewId: Long) {
        viewModelScope.launch {
            searchRepository.postReviewLike(reviewId)
                .onSuccess { bookReviewModel ->
                    _uiState.update { state ->
                        state.copy(
                            bookDetailUiModel = state.bookDetailUiModel.copy(
                                reviews = state.bookDetailUiModel.reviews.map { review ->
                                    if (review.reviewId == bookReviewModel.reviewId) {
                                        review.copy(
                                            likedNum = bookReviewModel.likedNum,
                                            isLiked = bookReviewModel.isLiked,
                                        )
                                    } else review
                                }.toImmutableList()
                            )
                        )
                    }
                }
        }
    }
}
