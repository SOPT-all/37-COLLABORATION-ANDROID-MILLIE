package sopt.org.millie.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.millie.core.util.UiState
import sopt.org.millie.presentation.home.model.BookCategoryModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCategories()
    }

    fun updateSearchKeyword(keyword: String) {
        _uiState.update { it.copy(searchKeyword = keyword) }
    }

    fun clearSearch() {
        _uiState.update { it.copy(searchKeyword = "") }
    }

    fun selectTab(tab: String) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

    fun onSearchAction() {
        val keyword = _uiState.value.searchKeyword
        // navigateToSearch(keyword) 이동 로직
    }

    fun loadCategories() {
        viewModelScope.launch {
            val mockCategories = listOf(
                BookCategoryModel(
                    categoryId = 1,
                    title = "소설",
                    description = "추리/스릴러, SF, 판타지 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 2,
                    title = "세계문학전집",
                    description = "열린책들, 민음사, 현대지성 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 3,
                    title = "에세이",
                    description = "자기계발, 삶, 여행 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 4,
                    title = "시/희곡",
                    description = "현대시, 고전시, 연극 희곡 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 5,
                    title = "인문학",
                    description = "철학, 역사, 심리학 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 6,
                    title = "과학/기술",
                    description = "IT, 물리, 생명과학 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 7,
                    title = "경제/경영",
                    description = "마케팅, 재테크, 경영전략 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 8,
                    title = "예술/대중문화",
                    description = "미술, 음악, 영화, 문화 전반",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 9,
                    title = "자기계발",
                    description = "습관, 마인드셋, 동기부여 등",
                    imageUrl = "",
                ),
                BookCategoryModel(
                    categoryId = 10,
                    title = "유아/어린이",
                    description = "그림책, 동화, 학습도서 등",
                    imageUrl = "",
                ),
            )
            _uiState.update { it.copy(categoryList = UiState.Success(mockCategories)) }
        }
    }
}
