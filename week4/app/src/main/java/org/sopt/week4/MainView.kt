package org.sopt.week4

// for a 'val' variable

// for a `var` variable also add

// or just
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// 메인 스크린
@Composable
fun MainScreen() {
    var totalScore by remember { mutableStateOf(0) }

    Column {
        ScoreCanvas(totalScore)
        ScoreStar { newTotalScore -> totalScore = newTotalScore }
    }
}

// 텍스트
@Composable
fun BasicText(text: String, color: Color) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        color = color,
    )
}

@Composable
fun ScoreCanvas(totalScore: Int) {
    /*
    val animatedValue = remember { Animatable(0f) }

    // 특정 값으로 색을 채우는 Animation
    LaunchedEffect(Unit) {
        animatedValue.animateTo(
            targetValue = totalScore.toFloat(),
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
        )
    }
*/

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .background(Color.LightGray),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sizeArc = size / 1.5F
            val center = Offset(size.width / 2f, size.height / 2f)

            drawArc(
                color = Color.Gray,
                startAngle = 180f, // 시작 각도
                sweepAngle = 180f, // 돌아갈 각도
                useCenter = false, // 호가 경계 중심부에 닿는가
                topLeft = Offset(
                    (size.width - sizeArc.width) / 2f,
                    (size.height - sizeArc.height) / 2f,
                ),
                size = sizeArc,
                style = Stroke(width = 25f),
            )

            drawArc(
                color = Color.Red,
                startAngle = 180f,
                sweepAngle = totalScore * 7.2f,
                useCenter = false,
                topLeft = Offset(
                    (size.width - sizeArc.width) / 2f,
                    (size.height - sizeArc.height) / 2f,
                ),
                size = sizeArc,
                style = Stroke(width = 25f),
            )

            // Arc 내 텍스트가 보여질 위치
            val textPosition1 = center + Offset(-0f, -150f)
            val textPosition2 = center + Offset(-0f, -40f)

            drawContext.canvas.nativeCanvas.drawText(
                "지금 내 점수는",
                textPosition1.x,
                textPosition1.y,
                Paint().apply {
                    color = Color.Gray.toArgb()
                    textSize = 40f
                    textAlign = Paint.Align.CENTER
                    isFakeBoldText = true
                },
            )

            val drawScore = (totalScore * 7.2f / 180 * 100).toInt()
            Log.d("그림 그려질 범위", drawScore.toString())

            drawContext.canvas.nativeCanvas.drawText(
                drawScore.toString(),
                textPosition2.x,
                textPosition2.y,
                Paint().apply {
                    color = Color.Red.toArgb()
                    textSize = 100f
                    textAlign = Paint.Align.CENTER
                    isFakeBoldText = true
                },
            )
        }
    }
}
