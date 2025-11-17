package sopt.org.millie.core.designsystem.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

//Brand Colors
val MillieYellow = Color(0xFFFFEB60)
val SubYellow = Color(0xFFFFB904)
val MilliePurple = Color(0xFFA451F7)
val SubPurple = Color(0xFF534165)
val AudioColor = Color(0xFFD16686)
val AudioColor2 = Color(0xFF2C9285)


//Greyscale Colors
val White = Color(0xFFFFFFFF)
val LightGray1 = Color(0xFFF5F4F3)
val LightGray2 = Color(0xFFDFDFDF)
val LightGray3 = Color(0xFFC1C1C1)
val Gray1 = Color(0xFFA5A5A5)
val Gray2 = Color(0xFF8B8B8B)
val Gray3 = Color(0xFF6F6F6F)
val Gray4 = Color(0xFF555555)
val DarkGray1 = Color(0xFF3D3D3D)
val DarkGray2 = Color(0xFF242424)
val Black = Color(0xFF000000)

//Background Colors
val Background = Color(0xFFFEFEFE)

@Immutable
data class MillieColors(
    val millieYellow: Color = MillieYellow,
    val subYellow: Color = SubYellow,
    val milliePurple: Color = MilliePurple,
    val subPurple: Color = SubPurple,
    val audioColor: Color = AudioColor,
    val audioColor2: Color = AudioColor2,

    val white: Color = White,
    val lightGray1: Color = LightGray1,
    val lightGray2: Color = LightGray2,
    val lightGray3: Color = LightGray3,
    val gray1: Color = Gray1,
    val gray2: Color = Gray2,
    val gray3: Color = Gray3,
    val gray4: Color = Gray4,
    val darkGray1: Color = DarkGray1,
    val darkGray2: Color = DarkGray2,
    val black: Color = Black,

    val background: Color = Background

)

val defaultMillieColors = MillieColors(
    millieYellow = MillieYellow,
    subYellow = SubYellow,
    milliePurple = MilliePurple,
    subPurple = SubPurple,
    audioColor = AudioColor,
    audioColor2 = AudioColor2,

    white = White,
    lightGray1 = LightGray1,
    lightGray2 = LightGray2,
    lightGray3 = LightGray3,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    darkGray1 = DarkGray1,
    darkGray2 = DarkGray2,
    black = Black,

    background = Background
)

val localMillieColorsProvider = staticCompositionLocalOf { defaultMillieColors }



