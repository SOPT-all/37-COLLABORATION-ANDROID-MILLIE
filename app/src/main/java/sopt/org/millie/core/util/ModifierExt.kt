package sopt.org.millie.core.util

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
inline fun Modifier.noRippleClickable(
    enabled: Boolean = true,
    crossinline onClick: () -> Unit,
): Modifier =
    composed {
        this.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { onClick() },
            enabled = enabled,
        )
    }

@Composable
fun Modifier.customShadow(
    shape: Shape,
    color: Color = Color.Black,
    blur: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    spread: Dp = 0f.dp,
) = composed {
    val localDensity = LocalDensity.current
    val paint = remember(color, blur) {
        Paint().apply {
            this.color = color
            val blurPx = with(localDensity) { blur.toPx() }

            if (blurPx > 0) {
                asFrameworkPaint().maskFilter =
                    BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL)
            }
        }
    }

    drawBehind {
        if (size.width == 0f || size.height == 0f) return@drawBehind

        val offsetXPx = offsetX.toPx()
        val offsetYPx = offsetY.toPx()
        val spreadPx = spread.toPx()

        val shadowWidth = size.width + spreadPx
        val shadowHeight = size.height + spreadPx

        val shadowSize = Size(width = shadowWidth, height = shadowHeight)
        val shadowOutline = shape.createOutline(size = shadowSize, layoutDirection = layoutDirection, density = this)

        drawIntoCanvas { canvas ->
            canvas.save()
            canvas.translate(dx = offsetXPx, dy = offsetYPx)
            canvas.drawOutline(outline = shadowOutline, paint = paint)
            canvas.restore()
        }
    }
}
