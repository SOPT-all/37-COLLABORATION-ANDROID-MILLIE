package sopt.org.millie.presentation.search.post

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.presentation.search.component.SearchTitle

@Composable
fun SearchPostTitle(
    modifier: Modifier = Modifier,
) {
    SearchTitle(
        title = "포스트",
        count = 736,
        modifier = modifier
            .padding(vertical = 10.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchPostScreenPreview() {
    MillieTheme {
        SearchPostTitle()
    }
}
