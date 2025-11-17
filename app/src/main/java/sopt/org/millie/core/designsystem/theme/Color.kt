package sopt.org.millie.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//Brand Colors
val MillieYellow = Color(0xFFFFEB60)
val SubYellow = Color(0xFFFFB904)
val MilliePurple = Color(0xFFA451F7)
val SubPurple = Color(0xFF534165)
val AudioColor = Color(0xFFD16686)
val AudioColor2 = Color(0xFF2C9285)


//Greyscale Colors
val White = Color(0xFFFFFFFF)
val LightGrey1 = Color(0xFFF5F4F3)
val LightGrey2 = Color(0xFFDFDFDF)
val LightGrey3 = Color(0xFFC1C1C1)
val Grey1 = Color(0xFFA5A5A5)
val Grey2 = Color(0xFF8B8B8B)
val Grey3 = Color(0xFF6F6F6F)
val Grey4 = Color(0xFF555555)
val DarkGrey1 = Color(0xFF3D3D3D)
val DarkGrey2 = Color(0xFF242424)
val Black = Color(0xFF000000)

//Background Colors
val Background = Color(0xFFFEFEFE)

@Immutable
data class DiveColors(
    val millieYellow: Color = MillieYellow,
    val subYellow: Color = SubYellow,
    val milliePurple: Color = MilliePurple,
    val subPurple: Color = SubPurple,
    val audioColor: Color = AudioColor,
    val audioColor2: Color = AudioColor2,

    val white: Color = White,
    val lightGrey1: Color = LightGrey1,
    val lightGrey2: Color = LightGrey2,
    val lightGrey3: Color = LightGrey3,
    val grey1: Color = Grey1,
    val grey2: Color = Grey2,
    val grey3: Color = Grey3,
    val grey4: Color = Grey4,
    val darkGrey1: Color = DarkGrey1,
    val darkGrey2: Color = DarkGrey2,
    val black: Color = Black,

    val background: Color = Background

)

val defaultDiveColors = DiveColors(
    millieYellow = MillieYellow,
    subYellow = SubYellow,
    milliePurple = MilliePurple,
    subPurple = SubPurple,
    audioColor = AudioColor,
    audioColor2 = AudioColor2,

    white = White,
    lightGrey1 = LightGrey1,
    lightGrey2 = LightGrey2,
    lightGrey3 = LightGrey3,
    grey1 = Grey1,
    grey2 = Grey2,
    grey3 = Grey3,
    grey4 = Grey4,
    darkGrey1 = DarkGrey1,
    darkGrey2 = DarkGrey2,
    black = Black,

    background = Background
)

val localDiveColorsProvider = staticCompositionLocalOf { defaultDiveColors }
