package sopt.org.millie.core.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
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
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        localMillieColorsProvider provides colors,
        localMillieTypographyProvider provides typography,
        content = content,
    )
}

@Composable
fun MillieTheme(
    content: @Composable () -> Unit,
) {
    ProvideColorsAndTypography(
        colors = defaultMillieColors,
        typography = defaultMillieTypography,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            content = content,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MillieMainColorsPreview() {
    MillieTheme {
        Column {
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.headLine,
                color = MillieTheme.colors.millieYellow,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.subHead5,
                color = MillieTheme.colors.subYellow,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.subHead4,
                color = MillieTheme.colors.milliePurple,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.subHead3,
                color = MillieTheme.colors.subPurple,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.subHead2,
                color = MillieTheme.colors.audioColor,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.title.subHead1,
                color = MillieTheme.colors.audioColor2,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.body3,
                color = MillieTheme.colors.lightGray1,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.body2,
                color = MillieTheme.colors.lightGray2,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.body1,
                color = MillieTheme.colors.lightGray3,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.subBody2,
                color = MillieTheme.colors.gray1,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.subBody1,
                color = MillieTheme.colors.gray2,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.caption4,
                color = MillieTheme.colors.gray3,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.caption3,
                color = MillieTheme.colors.gray4,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.caption2,
                color = MillieTheme.colors.darkGray1,
            )
            Text(
                "MillieTheme",
                style = MillieTheme.typography.body.caption1,
                color = MillieTheme.colors.darkGray2,
            )
        }
    }
}
