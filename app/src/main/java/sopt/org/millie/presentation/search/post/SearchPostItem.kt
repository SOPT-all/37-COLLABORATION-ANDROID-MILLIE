package sopt.org.millie.presentation.search.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun SearchPostItem(
    postImageUrl: String,
    title: String,
    description: String,
    writerUrl: String,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = MillieTheme.colors.white),
    ) {
        MillieImage(
            imageUrl = postImageUrl,
            modifier = Modifier
                .align(Alignment.Top)
                .size(width = 91.dp, height = 132.dp),
        )

        Column(
            modifier = Modifier
                .padding(start = 15.dp, end = 14.dp, top = 16.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PostBookInfo(title = title, description = description)

            PostWriterInfo(writerUrl = writerUrl, writerName = writerName, writerDate = writerDate)
        }
    }
}

@Composable
private fun PostBookInfo(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            text = title,
            style = MillieTheme.typography.title.subHead2,
            color = MillieTheme.colors.black,
        )

        Text(
            text = description,
            style = MillieTheme.typography.body.caption1,
            color = MillieTheme.colors.gray4,
            modifier = Modifier
                .padding(bottom = 6.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun PostWriterInfo(
    writerUrl: String,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MillieImage(
            imageUrl = writerUrl,
            modifier = Modifier
                .align(Alignment.Top)
                .clip(shape = CircleShape)
                .size(25.dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = writerName,
                style = MillieTheme.typography.body.caption1,
                color = MillieTheme.colors.darkGray1,
            )

            Text(
                text = writerDate,
                style = MillieTheme.typography.body.caption4,
                color = MillieTheme.colors.darkGray1,
            )
        }
    }
}

@Composable
private fun MillieImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
    )
}
