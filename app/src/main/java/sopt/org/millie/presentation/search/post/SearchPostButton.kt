package sopt.org.millie.presentation.search.post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.component.button.MillieButton
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchPostButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MillieButton(
        onClick = onClick,
        buttonBackgroundColor = MillieTheme.colors.lightGray1,
        buttonText = "전체보기",
        buttonTextStyle = MillieTheme.typography.body.subBody2,
        buttonTextColor = MillieTheme.colors.black,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchPostScreenPreview() {
    MillieTheme {
        SearchPostButton(onClick = {})
    }
}
