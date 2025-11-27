package sopt.org.millie.presentation.search.bookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.customShadow
import sopt.org.millie.presentation.search.bookdetail.component.bar.BookDetailTopbar
import sopt.org.millie.presentation.search.bookdetail.component.bar.ReadNowBar
import sopt.org.millie.presentation.search.bookdetail.component.book.BookDataSection
import sopt.org.millie.presentation.search.bookdetail.component.book.BookInfoSection
import sopt.org.millie.presentation.search.bookdetail.component.book.BookInfoSubtitle
import sopt.org.millie.presentation.search.bookdetail.component.book.BookIntroduceSection
import sopt.org.millie.presentation.search.bookdetail.component.book.BookReviewSection
import sopt.org.millie.presentation.search.bookdetail.component.book.BookSimilarSection

@Composable
fun BookDetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: BookDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BookDetailScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        onBackButtonClick = navigateUp,
        onCompletedRateClick = viewModel::onCompletedRateClicked,
        onAgeGenderClick = viewModel::onAgeGenderClicked,
        onImageClick = viewModel::onImageClicked,
        onReviewLikeClick = viewModel::onReviewLikeClicked,
    )
}

@Composable
private fun BookDetailScreen(
    uiState: BookDetailUiState,
    paddingValues: PaddingValues,
    onBackButtonClick: () -> Unit,
    onCompletedRateClick: () -> Unit,
    onAgeGenderClick: () -> Unit,
    onImageClick: () -> Unit,
    onReviewLikeClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    BookDetailContent(
        uiState = uiState,
        paddingValues = paddingValues,
        onBackButtonClick = onBackButtonClick,
        onCompletedRateClick = onCompletedRateClick,
        onAgeGenderClick = onAgeGenderClick,
        onImageClick = onImageClick,
        onReviewLikeClick = onReviewLikeClick,
    )
}

@Composable
private fun BookDetailContent(
    uiState: BookDetailUiState,
    paddingValues: PaddingValues,
    onBackButtonClick: () -> Unit,
    onCompletedRateClick: () -> Unit,
    onAgeGenderClick: () -> Unit,
    onImageClick: () -> Unit,
    onReviewLikeClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    var readNowBarHeight by remember { mutableStateOf(0.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding()),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = MillieTheme.colors.bookDetailBackground)
                .verticalScroll(state = rememberScrollState())
                .padding(bottom = readNowBarHeight),
        ) {
            Spacer(modifier = Modifier.height(22.dp + paddingValues.calculateTopPadding()))

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
                        color = MillieTheme.colors.subPurple.copy(
                            alpha = 0.1f,
                        ),
                        offsetX = 4.dp,
                        offsetY = 8.dp,
                        blur = 8.dp,
                    )
                    .customShadow(
                        shape = RoundedCornerShape(8.dp),
                        color = MillieTheme.colors.subPurple,
                        offsetX = 12.dp,
                        offsetY = 8.dp,
                        blur = 24.dp,
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
                            alpha = 0.1f,
                        ),
                        offsetY = (-5).dp,
                    )
                    .background(color = MillieTheme.colors.background)
                    .padding(top = 40.dp),
            ) {
                with(uiState.bookDetailUiModel) {
                    BookInfoSection(
                        bookTitle = bookTitle,
                        bookAuthor = bookAuthor,
                        bookType = bookType,
                        publishDate = publishedDate,
                        totalReviewCount = totalReviewCount,
                        bookRate = bookRate,
                        completionRate = completionRate,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Line()

                BookInfoSubtitle()

                Line()

                BookIntroduceSection(
                    bookDescription = uiState.bookDetailUiModel.bookDescription,
                    modifier = Modifier.padding(top = 50.dp, bottom = 30.dp),
                )

                Line()

                BookReviewSection(
                    totalReviewCount = uiState.bookDetailUiModel.totalReviewCount,
                    bookReviews = uiState.bookDetailUiModel.reviews,
                    onReviewLikeClick = onReviewLikeClick,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp),
                )

                Line()

                BookDataSection(
                    onCompletedRateClick = onCompletedRateClick,
                    onAgeGenderClick = onAgeGenderClick,
                    isCompletedGraphChanged = uiState.isCompletedGraphChanged,
                    selectedType = uiState.selectedType,
                    onImageClick = onImageClick,
                    modifier = Modifier.padding(vertical = 30.dp),
                )

                Line()

                BookSimilarSection(
                    books = uiState.similarBooks,
                    modifier = Modifier
                        .padding(top = 30.dp, bottom = 20.dp),
                )
            }
        }

        ReadNowBar(
            onButtonClick = {},
            modifier = Modifier
                .align(alignment = BottomCenter)
                .onGloballyPositioned {
                    readNowBarHeight = with(density) {
                        it.size.height.toDp()
                    }
                },
        )
    }
}

@Composable
private fun Line(
    modifier: Modifier = Modifier,
) {
    HorizontalDivider(
        thickness = 3.dp,
        color = MillieTheme.colors.lightGray1,
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDetailScreen(
            paddingValues = PaddingValues(),
            uiState = BookDetailUiState(),
            onBackButtonClick = {},
            onCompletedRateClick = {},
            onAgeGenderClick = {},
            onImageClick = {},
            onReviewLikeClick = {},
        )
    }
}
