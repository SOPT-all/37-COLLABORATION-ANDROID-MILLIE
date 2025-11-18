package sopt.org.millie.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun BookTitleAuthor(
    title: String,
    author: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = title,
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead3,
        )
        Text(
            text = author,
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.subBody2,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BookTitleAuthorPreview() {
    BookTitleAuthor("홍학의 자리", "정해연")
}
