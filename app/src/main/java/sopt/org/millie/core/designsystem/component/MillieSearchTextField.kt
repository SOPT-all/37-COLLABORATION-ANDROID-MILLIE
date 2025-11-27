package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.R
import sopt.org.millie.core.designsystem.theme.MillieTheme
import sopt.org.millie.core.util.noRippleClickable

@Composable
fun MillieSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable () -> Unit = {},
    onSearchAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)),
        textStyle = MillieTheme.typography.body.body2,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchAction()
                keyboardController?.hide()
            },
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MillieTheme.colors.lightGray1,
                        shape = RoundedCornerShape(22.dp),
                    )
                    .padding(horizontal = 13.dp, vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                    contentDescription = "검색",
                    tint = MillieTheme.colors.gray3,
                    modifier = Modifier.size(24.dp),
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 9.dp),
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = "검색어를 입력하세요",
                            style = MillieTheme.typography.body.body2,
                            color = MillieTheme.colors.lightGray3,
                        )
                    }
                    innerTextField()
                }

                if (value.isNotEmpty()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search_close),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .noRippleClickable(onClick = onCancelClick),
                        tint = Color.Unspecified,
                    )
                } else {
                    trailingIcon()
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun MillieSearchTextFieldPreview() {
    MillieTheme {
        var text by remember { mutableStateOf("") }

        MillieSearchTextField(
            value = text,
            onValueChange = { text = it },
            onCancelClick = {},
        )
    }
}
