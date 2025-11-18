package sopt.org.millie.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun MillieButton(
    onButtonClick: () -> Unit,
    buttonBackgroundColor: Color,
    buttonText: String,
    buttonTextStyle: TextStyle,
    buttonTextColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = buttonBackgroundColor, shape = RoundedCornerShape(4.dp))
            .noRippleClickable(onClick = onButtonClick)
            .padding(vertical = 10.dp),
    ) {
        Text(
            text = buttonText,
            modifier = Modifier.fillMaxWidth(),
            style = buttonTextStyle,
            color = buttonTextColor,
            textAlign = TextAlign.Center,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        MillieButton(
            onButtonClick = {},
            buttonBackgroundColor = MillieTheme.colors.millieYellow,
            buttonText = "버튼",
            buttonTextStyle = MillieTheme.typography.body.body1,
            buttonTextColor = MillieTheme.colors.black,
            modifier = Modifier.width(200.dp),
        )
    }
}
