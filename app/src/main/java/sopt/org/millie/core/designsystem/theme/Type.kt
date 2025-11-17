package sopt.org.millie.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import sopt.org.millie.R

object NotoSansFont {
    val bold = FontFamily(Font(R.font.noto_sans_kr_bold))
    val regular = FontFamily(Font(R.font.noto_sans_kr_regular))
}

private fun millieTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val headLine: TextStyle,
        val subHead5: TextStyle,
        val subHead4: TextStyle,
        val subHead3: TextStyle,
        val subHead2: TextStyle,
        val subHead1: TextStyle,
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
        val caption1: TextStyle,
    )
}

@Immutable
data class MillieTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
)

val defaultMillieTypography = MillieTypography(
    title = TypographyTokens.Title(
        headLine = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 20.sp,
            lineHeight = 28.sp,
        ),
        subHead5 = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 18.sp,
            lineHeight = 28.sp,
        ),
        subHead4 = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 16.sp,
            lineHeight = 22.sp,
        ),
        subHead3 = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 15.sp,
            lineHeight = 20.sp,
        ),
        subHead2 = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        ),
        subHead1 = millieTextStyle(
            fontFamily = NotoSansFont.bold,
            fontSize = 12.sp,
            lineHeight = 18.sp,
        ),
    ),
    body = TypographyTokens.Body(
        body3 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        body2 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 15.sp,
            lineHeight = 20.sp,
        ),
        body1 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        ),
        subBody2 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 13.sp,
            lineHeight = 18.sp,
        ),
        subBody1 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 11.sp,
            lineHeight = 18.sp,
        ),
        caption4 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 8.sp,
            lineHeight = 10.sp,
        ),
        caption3 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 12.sp,
            lineHeight = 18.sp,
        ),
        caption2 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 10.sp,
            lineHeight = 18.sp,
        ),
        caption1 = millieTextStyle(
            fontFamily = NotoSansFont.regular,
            fontSize = 9.sp,
            lineHeight = 14.sp,
        ),
    ),
)

val localMillieTypographyProvider = staticCompositionLocalOf { defaultMillieTypography }
