package sopt.org.millie.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sopt.org.millie.core.designsystem.theme.MillieTheme

@Composable
fun PostBookInfo(
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
            modifier = modifier
                .padding(bottom = 6.dp),
        )
    }
}

@Composable
fun PostWriterInfo(
    writerUrl: String,
    writerName: String,
    writerDate: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
    ) {
        MillieImage(
            imageUrl = writerUrl,
            modifier = Modifier
                .align(Alignment.TopStart)
                .clip(shape = CircleShape)
                .size(25.dp),
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 33.dp),
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
fun MillieImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
    )
}
