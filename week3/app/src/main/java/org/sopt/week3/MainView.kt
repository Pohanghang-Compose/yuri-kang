package org.sopt.week3

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week3.ui.theme.Week3Theme

// 메인 스크린
@Composable
fun SurveyScreen() {
    val showDialog = remember { mutableStateOf(false) }

    Column {
        SurveyBtn(showDialog)
        SurveyDialog(showDialog)
        ScoreCanvas(10)
    }
}

// 설문조사 버튼
@Composable
fun SurveyBtn(showDialog: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Button(
            onClick = { showDialog.value = true },
            modifier = Modifier.padding(horizontal = 50.dp),
        ) {
            Text(text = "설문조사 하기", color = Color.White)
        }
    }
}

// 점수 텍스트
@Composable
fun BasicText(text: String, color: Color) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        color = color,
    )
}

@Composable
fun ScoreCanvas(score: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sizeArc = size / 1.5F
            val center = Offset(size.width / 2f, size.height / 2f)

            drawArc(
                color = Color.Gray,
                startAngle = -180f, // 시작 각도
                sweepAngle = 180f, // 돌아갈 각도
                useCenter = false, // 호가 경계 중심부에 닿는가
                topLeft = Offset(
                    (size.width - sizeArc.width) / 2f,
                    (size.height - sizeArc.height) / 2f,
                ),
                size = sizeArc,
                style = Stroke(width = 25f),
            )
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

            drawContext.canvas.nativeCanvas.drawText(
                score.toString(),
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

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Week3Theme {
        ScoreCanvas(10)
    }
}
