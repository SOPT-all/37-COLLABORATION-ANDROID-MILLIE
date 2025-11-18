package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun MillieHeader(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    action: @Composable () -> Unit = {},
) {
    // Box가 있는 이유 : 아이콘이 왼쪽이 있을수도 있고 없을수도 있고, 오른쪽에 있을수도 있고 없을수도 있고.... 등등 겹쳐질 수 있는 부분이 있으므로 Box로 설정 (Row로 바로 설정 X)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MillieTheme.colors.background)
            .padding(horizontal = 13.dp, vertical = 12.dp),
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            navigationIcon()
        }

        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = MillieTheme.colors.black,
            style = MillieTheme.typography.title.subHead5,
        )

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            action()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MillieHeaderPreview() {
    MillieTheme {
        MillieHeader(
            "상단바",
            modifier = Modifier,
            navigationIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back_button),
                    contentDescription = null,
                    tint = MillieTheme.colors.black,
                )
            },
            action = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(R.drawable.ic_person),
                    contentDescription = null,
                    tint = MillieTheme.colors.black,
                )
            },
        )
    }
}
