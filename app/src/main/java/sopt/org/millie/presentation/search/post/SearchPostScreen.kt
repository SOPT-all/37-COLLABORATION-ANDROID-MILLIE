package sopt.org.millie.presentation.search.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchPostScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(MillieTheme.colors.background),
        contentPadding = PaddingValues(horizontal = 21.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        item { SearchPostTitle(count = posts.size) }

        items(
            items = posts,
            key = { it.postId },
        ) { post ->
            SearchPostItem(
                postImage = post.postImage,
                title = post.title,
                description = post.description,
                writerImage = post.writerImage,
                writerName = post.writerName,
                writerDate = post.writerDate,
            )
        }

        item {
            SearchPostButton(
            onClick = onClick,
            modifier = Modifier.padding(horizontal = 2.dp),
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchPostScreenPreview() {
    MillieTheme {
        SearchPostScreen(
            onClick = {},
        )
    }
}
