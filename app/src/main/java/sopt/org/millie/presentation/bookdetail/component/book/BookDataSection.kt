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

@Composable
fun BookDataSection(
    onCompletedRateClick: () -> Unit,
    completedTagBackgroundColor: Color,
    completedTagTextColor: Color,
    completedTagBorderColor: Color,
    onAgeGenderClick: () -> Unit,
    ageGenderTagBackgroundColor: Color,
    ageGenderTagTextColor: Color,
    ageGenderTagBorderColor: Color,
    isCompletedTag: Boolean,
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
            BookDetailTag(
                tagBackgroundColor = completedTagBackgroundColor,
                tagText = "완독지수",
                tagTextColor = completedTagTextColor,
                onTagClick = onCompletedRateClick,
                tagBorderColor = completedTagBorderColor,
            )

            BookDetailTag(
                tagBackgroundColor = ageGenderTagBackgroundColor,
                tagText = "연령·성별 인기",
                tagTextColor = ageGenderTagTextColor,
                onTagClick = onAgeGenderClick,
                tagBorderColor = ageGenderTagBorderColor,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        DataImage(isCompletedTag = isCompletedTag)
    }
}

@Composable
private fun DataImage(
    isCompletedTag: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (isCompletedTag) {
            Image(
                painter = painterResource(id = R.drawable.img_completed_rate),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
        } else {
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
                    withStyle(
                        style = MillieTheme.typography.body.body1.toSpanStyle(),
                    ) {
                        append("이 책이 속한 ")
                    }

                    withStyle(
                        style = MillieTheme.typography.title.subHead2.toSpanStyle(),
                    ) {
                        append("소설 분야\n")
                    }

                    withStyle(
                        style = MillieTheme.typography.body.body1.toSpanStyle(),
                    ) {
                        append("역시 ")
                    }

                    withStyle(
                        style = MillieTheme.typography.title.subHead2.toSpanStyle(),
                    ) {
                        append("20대 여성")
                    }

                    withStyle(
                        style = MillieTheme.typography.body.body1.toSpanStyle(),
                    ) {
                        append("이 가장 즐겨보고 있어요.")
                    }
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookDataSection(
            onCompletedRateClick = {},
            completedTagBackgroundColor = MillieTheme.colors.black,
            completedTagTextColor = MillieTheme.colors.white,
            completedTagBorderColor = Color.Transparent,
            onAgeGenderClick = {},
            ageGenderTagBackgroundColor = MillieTheme.colors.white,
            ageGenderTagTextColor = MillieTheme.colors.black,
            ageGenderTagBorderColor = MillieTheme.colors.darkGray1,
            isCompletedTag = false,
        )
    }
}
