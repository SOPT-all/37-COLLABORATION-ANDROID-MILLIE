package sopt.org.millie.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object DiveTheme {
    val colors: DiveColors
        @Composable
        @ReadOnlyComposable
        get() = localDiveColorsProvider.current

    val typography: DiveTypography
        @Composable
        @ReadOnlyComposable
        get() = localDiveTypographyProvider.current
}

@Composable
fun ProvideColorsAndTypography(
    colors: DiveColors,
    typography: DiveTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider (
        localDiveColorsProvider provides colors,
        localDiveTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun DiveTheme(
    content: @Composable () -> Unit
){
    ProvideColorsAndTypography(
        colors = defaultDiveColors,
        typography = defaultDiveTypography
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
