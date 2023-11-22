package org.sopt.week4

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ScoreStar(onTotalScoreChanged: (Int) -> Unit) {
    val surveyScores = remember { mutableStateListOf(0, 0, 0, 0, 0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Survey("컴포즈 스터디 만족도") { score -> surveyScores[0] = score }
        Survey("컴포즈 스터디 난이도") { score -> surveyScores[1] = score }
        Survey("오늘 점심 메뉴 만족도") { score -> surveyScores[2] = score }
        Survey("오늘 저녁 메뉴 만족도") { score -> surveyScores[3] = score }
        Survey("솝트 만족도") { score -> surveyScores[4] = score }
    }

    val sumScore = remember { mutableStateOf(0) }
    sumScore.value = surveyScores.sum()
    onTotalScoreChanged(sumScore.value)
}

@Composable
fun Survey(text: String, onScoreSelected: (Int) -> Unit) {
    val isMenuExpandedState = remember { mutableStateOf(false) }
    val selectedMenuItem = remember { mutableStateOf(0) }

    Row(modifier = Modifier.padding(vertical = 13.dp)) {
        BasicText(text, Color.Black)

        Column() {
            // 메뉴 다운 버튼

            Icon(
                imageVector = if (isMenuExpandedState.value) {
                    Icons.Default.KeyboardArrowUp
                } else {
                    Icons.Default.KeyboardArrowDown
                },
                contentDescription = text,
                modifier = Modifier.clickable {
                    isMenuExpandedState.value = !isMenuExpandedState.value
                },
            )
            Log.d("클릭", isMenuExpandedState.value.toString())

            // 메뉴
            DropDownMenu(isMenuExpandedState) { menuItem ->
                selectedMenuItem.value = menuItem

                Log.d("점수", selectedMenuItem.value.toString())
                onScoreSelected(selectedMenuItem.value)
            }
        }
    }
    ScoreStar(selectedMenuItem.value)
}

@Composable
fun ScoreStar(score: Int) {
    Row(modifier = Modifier.padding(bottom = 15.dp).animateContentSize()) { // 애니메이션 추가
        if (score == 0) {
            Spacer(modifier = Modifier.size(20.dp))
        } else {
            repeat(score) {
                Icon(
                    imageVector = Icons.Default.Star,
                    tint = Color.Yellow,
                    contentDescription = "점수",
                    modifier = Modifier.size(20.dp),
                )
            }
        }
    }
}

@Composable
fun DropDownMenu(isMenuExpanded: MutableState<Boolean>, onMenuItemClick: (Int) -> Unit) {
    DropdownMenu(
        modifier = Modifier.wrapContentSize(),
        expanded = isMenuExpanded.value,
        onDismissRequest = { isMenuExpanded.value = false },
    ) {
        repeat(5) {
            DropdownMenuItem(it + 1, onMenuItemClick)
        }
    }
}

// 점수 메뉴 아이템
@Composable
fun DropdownMenuItem(score: Int, onMenuItemClick: (Int) -> Unit) {
    androidx.compose.material3.DropdownMenuItem(
        { Text(text = score.toString()) },
        onClick = { onMenuItemClick(score) },
    )
}
