package sopt.org.millie.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object MillieTheme {
    val colors: MillieColors
        @Composable
        @ReadOnlyComposable
        get() = localMillieColorsProvider.current

    val typography: MillieTypography
        @Composable
        @ReadOnlyComposable
        get() = localMillieTypographyProvider.current
}

@Composable
fun ProvideColorsAndTypography(
    colors: MillieColors,
    typography: MillieTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider (
        localMillieColorsProvider provides colors,
        localMillieTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun MillieTheme(
    content: @Composable () -> Unit
){
    ProvideColorsAndTypography(
        colors = defaultMillieColors,
        typography = defaultMillieTypography
    ) {
        val view = LocalView.current
        if(!view.isInEditMode){
            SideEffect {
                (view.context as Activity).window.run{
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}
