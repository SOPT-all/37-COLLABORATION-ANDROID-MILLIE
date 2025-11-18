package sopt.org.millie.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun MillieButton(
    onClick: () -> Unit,
    buttonBackgroundColor: Color,
    buttonText: String,
    buttonTextStyle: TextStyle,
    buttonTextColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(color = buttonBackgroundColor)
            .noRippleClickable(onClick = onClick)
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = buttonText,
            style = buttonTextStyle,
            color = buttonTextColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MillieTheme {
        MillieButton(
            onClick = {},
            buttonBackgroundColor = MillieTheme.colors.darkGray1,
            buttonText = "바로 읽기",
            buttonTextStyle = MillieTheme.typography.body.body3,
            buttonTextColor = MillieTheme.colors.white,
            modifier = Modifier.width(200.dp),
        )
    }
}
