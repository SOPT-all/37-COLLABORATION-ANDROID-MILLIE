package sopt.org.millie.presentation.search.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchTitle(
    title: String,
    count: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(end = 4.dp),
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.headLine,
        )
        Text(
            text = count.toString(),
            color = MillieTheme.colors.milliePurple,
            style = MillieTheme.typography.title.subHead2,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTitlePreview() {
    SearchTitle("도서", 4)
}
