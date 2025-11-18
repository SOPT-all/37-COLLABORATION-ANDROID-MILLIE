package sopt.org.millie.core.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun MillieImage(
    imageUrl: String,
//    a: String,
//    height: String,
//    width: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
//        modifier = modifier
//            .align(a)
//            .size(width.dp, height.dp),
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
    )
}
