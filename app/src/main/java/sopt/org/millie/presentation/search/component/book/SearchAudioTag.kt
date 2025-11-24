package sopt.org.millie.presentation.search.component.book

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.component.MillieBadge
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchAudioTag(
    voiceActor: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MillieBadge(
            text = "오디오 북",
            color = MillieTheme.colors.milliePurple,
            radius = 16.dp,
        )

        Text(
            text = voiceActor,
            modifier = Modifier
                .padding(start = 4.dp),
            color = MillieTheme.colors.milliePurple,
            style = MillieTheme.typography.title.subHead1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchAudioTagPreview() {
    SearchAudioTag(
        voiceActor = "김지윤,박지윤",
    )
}
