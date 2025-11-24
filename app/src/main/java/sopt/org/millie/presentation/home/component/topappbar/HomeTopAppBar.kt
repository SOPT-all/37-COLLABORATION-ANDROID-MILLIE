package sopt.org.millie.presentation.home.component.topappbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieTopappbar
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun HomeTopAppBar(modifier: Modifier = Modifier) {
    MillieTopappbar(
        title = "검색",
        action = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_profile),
                contentDescription = null,
                tint = MillieTheme.colors.black,
            )
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun HomeTopAppBarPreview() {
    MillieTheme {
        HomeTopAppBar()
    }
}
