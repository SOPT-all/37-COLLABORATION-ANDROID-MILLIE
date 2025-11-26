package sopt.org.millie.presentation.search.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.millie.core.util.UiState
import sopt.org.millie.data.repository.SearchRepository
import sopt.org.millie.presentation.search.home.model.BookCategoryModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val searchRepository: SearchRepository,
) : ViewModel() {
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
        // navigateToSearch(keyword)
    }

    fun loadCategories() {
        viewModelScope.launch {
            searchRepository.getCategories()
                .onSuccess { categoryResponseModels ->
                    val categoryModels = categoryResponseModels.map {
                        BookCategoryModel(
                            categoryId = it.categoryId,
                            title = it.title,
                            description = it.description,
                            imageUrl = it.imageUrl,
                        )
                    }
                    _uiState.update { it.copy(categoryList = UiState.Success(categoryModels.toImmutableList())) }
                }
                .onFailure { }
        }
    }
}
