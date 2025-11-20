package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun MillieTabbarText(
    title: String,
    selected: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

) {
    Column (
        modifier = modifier.width(IntrinsicSize.Max)
    ) {
        Text(
            text = title,
            modifier = modifier
                .padding(top = 10.dp)
                .clickable{onClick()}
                .padding(bottom = 8.dp),
            color = MillieTheme.colors.black,
            style = if (selected) MillieTheme.typography.title.subHead4 else MillieTheme.typography.body.body3,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = if (selected) MillieTheme.colors.black else MillieTheme.colors.white)
        )

    }

}



@Preview(showBackground = true)
@Composable
private fun MillieTabbarTextPreview() {
    MillieTheme {
        SearchTabbar()
    }
}


