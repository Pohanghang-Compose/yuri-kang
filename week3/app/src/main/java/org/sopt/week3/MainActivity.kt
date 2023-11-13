package org.sopt.week3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week3.ui.theme.Week3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SurveyDialog()
                }
            }
        }
    }
}

// 설문조사 버튼
@Composable
fun SurveyBtn(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 50.dp),
    ) {
        Text(text = "설문조사 하기", color = Color.White)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week3Theme {
        TotalScore(0)
    }
}
