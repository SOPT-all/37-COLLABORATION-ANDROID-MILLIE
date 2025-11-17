package sopt.org.millie.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import sopt.org.millie.R


object PretendardFont {
    val bold = FontFamily(Font(R.font.noto_sans_kr_bold))
    val regular = FontFamily(Font(R.font.noto_sans_kr_regular))
}

sealed interface TypographyTokens{
    @Immutable
    data class Title(
        val headLine: TextStyle,
        val subHead5: TextStyle,
        val subHead4: TextStyle,
        val subHead3: TextStyle,
        val subHead2: TextStyle,
        val subHead1: TextStyle
    )

    @Immutable
    data class Body(
        val body3: TextStyle,
        val body2: TextStyle,
        val body1: TextStyle,
        val subBody2: TextStyle,
        val subBody1: TextStyle,
        val caption4: TextStyle,
        val caption3: TextStyle,
        val caption2: TextStyle,
        val caption1: TextStyle
    )
}

@Immutable
data class DiveTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body
)


val defaultDiveTypography = DiveTypography(
    title = TypographyTokens.Title(
        headLine = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 20.sp,
            lineHeight = 28.sp, // 120%
            letterSpacing = (-1).sp
        ),
        subHead5 = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 18.sp,
            lineHeight = 28.sp, // 120%
            letterSpacing = (-1).sp
        ),
        subHead4 = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 16.sp,
            lineHeight = 22.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        subHead3 = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 15.sp,
            lineHeight = 20.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        subHead2 = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 14.sp,
            lineHeight = 20.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        subHead1 = TextStyle(
            fontFamily = PretendardFont.bold,
            fontSize = 12.sp,
            lineHeight = 16.sp, // 120%
            letterSpacing = (-0.6).sp
        )
    ),
    body = TypographyTokens.Body(
        body3 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 16.sp,
            lineHeight = 24.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        body2 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 15.sp,
            lineHeight = 20.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        body1 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 14.sp,
            lineHeight = 22.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        subBody2 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 13.sp,
            lineHeight = 18.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        subBody1 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 11.sp,
            lineHeight = 18.sp, // 120%
            letterSpacing = 0.sp
        ),
        caption4 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 8.sp,
            lineHeight = 10.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        caption3 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 12.sp,
            lineHeight = 18.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        caption2 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 10.sp,
            lineHeight = 18.sp, // 120%
            letterSpacing = (-0.6).sp
        ),
        caption1 = TextStyle(
            fontFamily = PretendardFont.regular,
            fontSize = 9.sp,
            lineHeight = 14.sp, // 120%
            letterSpacing = (-0.6).sp
        )
    )
)

val localDiveTypographyProvider = staticCompositionLocalOf { defaultDiveTypography }
