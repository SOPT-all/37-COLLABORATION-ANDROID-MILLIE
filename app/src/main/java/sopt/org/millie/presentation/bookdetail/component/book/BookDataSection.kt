package sopt.org.millie.presentation.bookdetail.component.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.bookdetail.component.tag.BookDetailTag
import sopt.org.millie.presentation.bookdetail.model.BookDataType

@Composable
fun BookDataSection(
    onCompletedRateClick: () -> Unit,
    onAgeGenderClick: () -> Unit,
    isCompletedGraphChanged: Boolean,
    selectedType: BookDataType,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "이 책의 독서 데이터",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead4,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BookDataType.entries.forEach { bookDataType ->
                val isSelected = bookDataType == selectedType
                val (tagBackground, tagText, tagBorder) = if (isSelected) {
                    Triple(MillieTheme.colors.black, MillieTheme.colors.white, Color.Transparent)
                } else {
                    Triple(MillieTheme.colors.white, MillieTheme.colors.black, MillieTheme.colors.lightGray3)
                }

                BookDetailTag(
                    tagBackgroundColor = tagBackground,
                    tagText = bookDataType.bookDataType,
                    tagTextColor = tagText,
                    onTagClick = when (bookDataType) {
                        BookDataType.COMPLETED_RATE -> onCompletedRateClick
                        BookDataType.AGE_GENDER -> onAgeGenderClick
                    },
                    tagBorderColor = tagBorder,
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        DataImage(
            isCompletedGraphChanged = isCompletedGraphChanged,
            bookDataType = selectedType,
        )
    }
}

@Composable
private fun DataImage(
    isCompletedGraphChanged: Boolean,
    bookDataType: BookDataType,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        when (bookDataType) {
            BookDataType.COMPLETED_RATE -> {
                if (isCompletedGraphChanged) {
                    Image(
                        painter = painterResource(id = R.drawable.img_completed_rate1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth,
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.img_completed_rate2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth,
                    )
                }
            }

            BookDataType.AGE_GENDER -> {
                Image(
                    painter = painterResource(id = R.drawable.img_age_gender),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    buildAnnotatedString {
                        val body = MillieTheme.typography.body.body1.toSpanStyle()
                        val title = MillieTheme.typography.title.subHead2.toSpanStyle()

                        withStyle(body) { append("이 책이 속한 ") }

                        withStyle(title) { append("소설 분야\n") }

                        withStyle(body) { append("역시 ") }

                        withStyle(title) { append("20대 여성") }

                        withStyle(body) { append("이 가장 즐겨보고 있어요.") }
                    },
                    color = MillieTheme.colors.darkGray2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = MillieTheme.colors.lightGray1)
                        .padding(vertical = 11.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDataSection(
            onCompletedRateClick = {},
            onAgeGenderClick = {},
            isCompletedGraphChanged = true,
            selectedType = BookDataType.COMPLETED_RATE,
        )
    }
}
