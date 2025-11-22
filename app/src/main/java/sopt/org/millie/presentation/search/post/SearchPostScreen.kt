package sopt.org.millie.presentation.search.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sopt.org.millie.core.designsystem.theme.MillieTheme
import java.util.UUID

@Composable
fun SearchPostScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(MillieTheme.colors.white),
        contentPadding = PaddingValues(horizontal = 21.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        item { SearchPostTitle(count = posts.size) }

        items(
            items = posts,
            key = { it.postId },
        ) { post ->
        SearchPostItem(
            postImageUrl = post.postImageUrl,
            title = post.title,
            description = post.description,
            writerUrl = post.writerUrl,
            writerName = post.writerName,
            writerDate = post.writerDate,
        )
        }

        item { SearchPostButton(onClick = {}) }
    }
}

data class SearchPostListModel(
    val postImageUrl: String,
    val title: String,
    val description: String,
    val writerUrl: String,
    val writerName: String,
    val writerDate: String,
    val postId: String = UUID.randomUUID().toString(),
)

private val posts = listOf(
    SearchPostListModel(
        postImageUrl = "",
        title = "홍학의 자리",
        description = "독서를 취미로 삼고자 좋아하는 이꼬르영 유튜버의 추천 및 이미 베스트셀러로 유명세를 타던 홍학의자리를 읽…",
        writerUrl = "",
        writerName = "뇌쉑걸의 서재",
        writerDate = "2024.02.05",
    ),
    SearchPostListModel(
        postImageUrl = "",
        title = "[책리뷰]홍학의 자리(정혜연)",
        description = "#책리뷰 #홍학의자리 #김정해연 #엘렉시르. *내용:한 학생의 죽음을 바탕으로 펼쳐지는 추리 스릴러 *감상 : 헉...!…",
        writerUrl = "",
        writerName = "북렌즈 Booklenz의 서재 ",
        writerDate = "2024.07.03",
    ),
    SearchPostListModel(
        postImageUrl = "",
        title = "홍학의 자리",
        description = "정해연 작가의 홍학의 자리는 단순한 범죄 소설의 틀을 넘어 인간 내면의 어둠과 심리를 섬세하게 파헤치는 작…",
        writerUrl = "",
        writerName = "수염이 멋진 연필_48706의 서재",
        writerDate = "2025.04.21",
    ),
    SearchPostListModel(
        postImageUrl = "",
        title = "홍학의 자리",
        description = "유괴의 날, 홍학의자리를 연속으로 읽고 내가 가장 좋아하는 작가는 정해연 작가라고 가슴에 새기고 있습니다. 다음…",
        writerUrl = "",
        writerName = "갑부대빵의 서재",
        writerDate = "2024.08.30",
    ),
)

@Preview
@Composable
private fun SearchPostScreenPreview() {
    MillieTheme {
        SearchPostScreen()
    }
}
