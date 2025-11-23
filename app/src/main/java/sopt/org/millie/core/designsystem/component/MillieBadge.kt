package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun MillieBadge(
    text: String,
    color: Color,
    radius: Dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(radius),
            )
            .padding(horizontal = 5.dp, vertical = 2.dp),
    ) {
        Text(
            text = text,
            color = color,
            style = MillieTheme.typography.body.caption4,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MillieBadgePreview() {
    MillieBadge(
        text = "오디오 북",
        color = MillieTheme.colors.milliePurple,
        radius = 16.dp,
    )
}
