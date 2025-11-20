package sopt.org.millie.presentation.bookdetail.component.book

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun BookIntroduceSection(
    reviewContent: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "책 소개",
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead4,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "$reviewContent",
            color = MillieTheme.colors.darkGray1,
            style = MillieTheme.typography.body.body1,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "더보기",
            modifier = Modifier
                .align(alignment = Alignment.End)
                .clickable(onClick = onClick),
            color = MillieTheme.colors.milliePurple,
            style = MillieTheme.typography.body.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        BookIntroduceSection(
            reviewContent = "dfasdjfasdfasdfas",
            onClick = {},
        )
    }
}
