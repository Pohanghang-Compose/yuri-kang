package org.sopt.week3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week3.ui.theme.Week3Theme

// 설문조사 버튼
@Composable
fun SurveyBtn(showDialog: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp).fillMaxWidth(),
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

// 점수
@Composable
fun TotalScore(score: Int) {
    Text(
        text = score.toString(),
        textAlign = TextAlign.Center,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
    )
}

// 메인 스크린
@Composable
fun SurveyScreen() {
    val showDialog = remember { mutableStateOf(false) }

    Column {
        SurveyBtn(showDialog)
        SurveyDialog(showDialog)
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Week3Theme {
        SurveyScreen()
    }
}
