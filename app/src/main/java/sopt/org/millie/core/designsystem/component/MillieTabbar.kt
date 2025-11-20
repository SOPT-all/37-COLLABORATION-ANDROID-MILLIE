package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SearchTabbar(
    modifier: Modifier = Modifier,
){
    var selectedTab by remember { mutableStateOf("도서") }
    val tab = mutableListOf("도서","밀리로드","포스트","서재")

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        tab.forEachIndexed { index, title ->
            MillieTabbarText(
                title = title,
                selected = selectedTab == title,
                onClick = { selectedTab = title },
            )
        }
//
//
//        MillieTabbarText(
//            title = "밀리로드",
//            selected = selectedTab == "밀리로드",
//            onClick = { selectedTab = "밀리로드" },
//        )
//
//        MillieTabbarText(
//            title = "포스트",
//            selected = selectedTab == "포스트",
//            onClick = { selectedTab = "포스트" },
//        )
//
//        MillieTabbarText(
//            title = "서재",
//            selected = selectedTab == "서재",
//            onClick = { selectedTab = "서재" },
//        )
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchTabbarPreview() {
    MillieTheme {
        SearchTabbar()
    }
}
