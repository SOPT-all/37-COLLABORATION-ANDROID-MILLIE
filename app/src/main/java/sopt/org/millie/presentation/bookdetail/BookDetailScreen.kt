package sopt.org.millie.presentation.bookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow
import sopt.org.millie.presentation.bookdetail.component.bar.BookDetailTopbar
import sopt.org.millie.presentation.bookdetail.component.bar.ReadNowBar
import sopt.org.millie.presentation.bookdetail.component.book.BookDataSection
import sopt.org.millie.presentation.bookdetail.component.book.BookInfoSection
import sopt.org.millie.presentation.bookdetail.component.book.BookInfoSubtitle
import sopt.org.millie.presentation.bookdetail.component.book.BookIntroduceSection
import sopt.org.millie.presentation.bookdetail.component.book.BookReviewSection
import sopt.org.millie.presentation.bookdetail.component.book.BookSimilarSection

@Composable
fun BookDetailRoute(
    viewModel: BookDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BookDetailScreen(
        uiState = uiState,
        onBackButtonClick = viewModel::onBackButtonClicked,
        onCompletedRateClick = viewModel::onCompletedRateClicked,
        onAgeGenderClick = viewModel::onAgeGenderClicked,
        onImageClick = viewModel::onImageClicked
    )
}

@Composable
private fun BookDetailScreen(
    uiState: BookDetailState,
    onBackButtonClick: () -> Unit,
    onCompletedRateClick: () -> Unit,
    onAgeGenderClick: () -> Unit,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        BookDetailContent(
            uiState = uiState,
            onBackButtonClick = onBackButtonClick,
            onCompletedRateClick = onCompletedRateClick,
            onAgeGenderClick = onAgeGenderClick,
            onImageClick = onImageClick,
        )

        ReadNowBar(
            onButtonClick = {},
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun BookDetailContent(
    uiState: BookDetailState,
    onBackButtonClick: () -> Unit,
    onCompletedRateClick: () -> Unit,
    onAgeGenderClick: () -> Unit,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MillieTheme.colors.bookDetailBackground)
            .verticalScroll(state = rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(22.dp))

        BookDetailTopbar(
            bookDetailTopbarBackgroundColor = MillieTheme.colors.bookDetailBackground,
            onBackButtonClick = onBackButtonClick,
        )

        AsyncImage(
            model = uiState.bookDetailUiModel.bookCoverImageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 84.dp, vertical = 46.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .customShadow(
                    shape = RoundedCornerShape(8.dp),
                    color = MillieTheme.colors.black.copy(
                        alpha = 0.1f
                    ),
                    offsetX = 4.dp,
                    offsetY = 8.dp
                )
                .customShadow(
                    shape = RoundedCornerShape(8.dp),
                    color = MillieTheme.colors.black.copy(
                        alpha = 0.2f
                    ),
                    offsetX = 12.dp,
                    offsetY = 8.dp
                ),
            contentScale = ContentScale.Crop,

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .customShadow(
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                    color = MillieTheme.colors.black.copy(
                        alpha = 0.1f
                    ),
                    offsetY = (-5).dp
                )
                .background(color = MillieTheme.colors.white)
                .padding(top = 40.dp)
        ) {
            BookInfoSection(
                bookTitle = uiState.bookDetailUiModel.bookTitle,
                bookAuthor = uiState.bookDetailUiModel.bookAuthor,
                bookType = uiState.bookDetailUiModel.bookType,
                publishDate = uiState.bookDetailUiModel.publishedDate,
                totalReviewCount = uiState.bookDetailUiModel.totalReviewCount,
                bookRate = uiState.bookDetailUiModel.bookRate,
                completionRate = uiState.bookDetailUiModel.completionRate,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Line()

            BookInfoSubtitle()

            Line()

            BookIntroduceSection(
                bookDescription = uiState.bookDetailUiModel.bookDescription,
                modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
            )

            Line()

            BookReviewSection(
                totalReviewCount = uiState.bookDetailUiModel.totalReviewCount,
                bookReviews = uiState.bookDetailUiModel.reviews,
                onReviewLikeClick = {},
            )

            Line()

            BookDataSection(
                onCompletedRateClick = onCompletedRateClick,
                onAgeGenderClick = onAgeGenderClick,
                isCompletedGraphChanged = uiState.isCompletedGraphChanged,
                selectedType = uiState.selectedType,
                onImageClick = onImageClick,
                modifier = Modifier.padding(vertical = 30.dp)
            )

            Line()

            BookSimilarSection(
                books = uiState.similarBooks,
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp)
            )
        }
    }
}

@Composable
private fun Line(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(color = MillieTheme.colors.lightGray1)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDetailScreen(
            uiState = BookDetailState(),
            onBackButtonClick = {},
            onCompletedRateClick = {},
            onAgeGenderClick = {},
            onImageClick = {}
        )
    }

}
