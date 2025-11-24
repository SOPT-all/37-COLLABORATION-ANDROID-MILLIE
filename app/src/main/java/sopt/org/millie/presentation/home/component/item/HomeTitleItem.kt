package sopt.org.millie.presentation.home.component.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun HomeTitleItem(
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MillieTheme.typography.title.headLine,
            color = MillieTheme.colors.black,
        )
    }
}
