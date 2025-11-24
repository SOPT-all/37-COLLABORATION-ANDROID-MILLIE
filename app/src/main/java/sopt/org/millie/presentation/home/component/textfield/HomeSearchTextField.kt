package sopt.org.millie.presentation.home.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.component.MillieSearchTextField
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun HomeSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    onSearchAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MillieTheme.colors.white)
            .padding(top = 9.dp, bottom = 17.dp)
            .padding(horizontal = 16.dp),
    ) {
        MillieSearchTextField(
            value = value,
            onValueChange = onValueChange,
            onCancelClick = onCancelClick,
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_search_scan),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified,
                )
            },
            onSearchAction = onSearchAction,
        )
    }
}

@Preview
@Composable
private fun HomeSearchTextFieldIPreview() {
    MillieTheme {
        var text by remember { mutableStateOf("") }

        HomeSearchTextField(
            value = text,
            onValueChange = { text = it },
            onCancelClick = { text = "" },
            onSearchAction = { },
        )
    }
}
