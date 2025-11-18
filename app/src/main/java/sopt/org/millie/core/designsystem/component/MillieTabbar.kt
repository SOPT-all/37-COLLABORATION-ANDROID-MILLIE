package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchTabbar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
//        SearchTabbarText("도서")
//        SearchTabbarText("밀리로드")
//        SearchTabbarText("포스트")
//        SearchTabbarText("서재")
        SearchTabbarText("카테고리")
        SearchTabbarText("웹툰/웹소설")
        SearchTabbarText("오디오")
        SearchTabbarText("작가")
        SearchTabbarText("오디오")
    }
}

@Composable
private fun SearchTabbarText(
    name: String,
    modifier: Modifier = Modifier,
    nowTabbar: Boolean = false,
) {
    Text(
        text = name,
        modifier = modifier
            .padding(vertical = 10.dp),
        color = MillieTheme.colors.black,
        style = if (nowTabbar) MillieTheme.typography.title.subHead4 else MillieTheme.typography.body.body3,
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchTabbarPreview() {
    MillieTheme {
        SearchTabbar()
    }
}
