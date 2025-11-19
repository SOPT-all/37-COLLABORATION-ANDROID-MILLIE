package sopt.org.millie.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable () -> Unit = {},
    onSearchAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)),
        textStyle = MillieTheme.typography.body.body2,
        placeholder = {
            Text(
                text = "검색어를 입력하세요",
                color = MillieTheme.colors.gray3,
                style = MillieTheme.typography.body.body2,
            )
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = "검색",
                tint = MillieTheme.colors.gray3,
                modifier = Modifier.size(24.dp),
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search_close),
                    contentDescription = "삭제",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(24.dp)
                        .noRippleClickable(
                            onClick = onCancelClick,
                        ),
                )
            } else {
                trailingIcon()
            }
        },
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
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MillieTheme.colors.lightGray1,
            unfocusedContainerColor = MillieTheme.colors.lightGray1,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchTextFieldPreview() {
    MillieTheme {
        var text by remember { mutableStateOf("") }

        SearchTextField(
            value = text,
            onValueChange = { text = it },
        )
    }
}
