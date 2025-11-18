package sopt.org.millie.presentation.search.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun BookAudioMark(
    reader: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MillieTheme.colors.milliePurple,
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(horizontal = 5.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(id = R.string.audio_book),
                color = MillieTheme.colors.milliePurple,
                style = MillieTheme.typography.body.caption4,
            )
        }
        Text(
            text = reader,
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1f),
            color = MillieTheme.colors.milliePurple,
            style = MillieTheme.typography.title.subHead1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BookAudioMarkPreview() {
    BookAudioMark(
        reader = "김지윤,박지윤",
    )
}
