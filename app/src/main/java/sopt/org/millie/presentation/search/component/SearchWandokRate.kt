package sopt.org.millie.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
fun SearchWandokRate(
    rate: String,
    minute: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_result_wandok),
            contentDescription = null,
            modifier = Modifier.size(15.dp),
            tint = MillieTheme.colors.gray3,
        )
        Text(
            text = rate,
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.body1,
        )
        Text(
            text = "|",
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.body1,
        )
        Text(
            text = minute,
            color = MillieTheme.colors.gray3,
            style = MillieTheme.typography.body.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchWandokRatePreview() {
    SearchWandokRate(
        rate = "88%",
        minute = "247분",
    )
}
