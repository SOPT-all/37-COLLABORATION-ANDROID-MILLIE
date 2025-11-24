package sopt.org.millie.presentation.search.post

import sopt.org.millie.R
import java.util.UUID

data class SearchPostListModel(
    val postImage: Int,
    val title: String,
    val description: String,
    val writerImage: Int,
    val writerName: String,
    val writerDate: String,
    val postId: String = UUID.randomUUID().toString(),
)

val posts = listOf(
    SearchPostListModel(
        postImage = R.drawable.img_searh_post_book,
        title = "홍학의 자리",
        description = "독서를 취미로 삼고자 좋아하는 이꼬르영 유튜버의 추천 및 이미 베스트셀러로 유명세를 타던 홍학의자리를 읽…",
        writerImage = R.drawable.img_search_post_reviewer_1,
        writerName = "뇌쉑걸의 서재",
        writerDate = "2024.02.05",
    ),
    SearchPostListModel(
        postImage = R.drawable.img_searh_post_book,
        title = "[책리뷰]홍학의 자리(정혜연)",
        description = "#책리뷰 #홍학의자리 #김정해연 #엘렉시르. *내용:한 학생의 죽음을 바탕으로 펼쳐지는 추리 스릴러 *감상 : 헉...!…",
        writerImage = R.drawable.img_search_post_reviewer_2,
        writerName = "북렌즈 Booklenz의 서재 ",
        writerDate = "2024.07.03",
    ),
    SearchPostListModel(
        postImage = R.drawable.img_searh_post_book,
        title = "홍학의 자리",
        description = "정해연 작가의 홍학의 자리는 단순한 범죄 소설의 틀을 넘어 인간 내면의 어둠과 심리를 섬세하게 파헤치는 작…",
        writerImage = R.drawable.img_search_post_reviewer_3,
        writerName = "수염이 멋진 연필_48706의 서재",
        writerDate = "2025.04.21",
    ),
    SearchPostListModel(
        postImage = R.drawable.img_searh_post_book,
        title = "홍학의 자리",
        description = "유괴의 날, 홍학의자리를 연속으로 읽고 내가 가장 좋아하는 작가는 정해연 작가라고 가슴에 새기고 있습니다. 다음…",
        writerImage = R.drawable.img_search_post_reviewer_3,
        writerName = "갑부대빵의 서재",
        writerDate = "2024.08.30",
    ),
)
