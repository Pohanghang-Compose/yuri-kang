package org.sopt.week3

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week3.ui.theme.Week3Theme

@Composable
fun SurveyDialog(showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = {
                Text(text = "설문조사 LIST")
            },
            text = {
                Column {
                    Survey("컴포즈 스터디 만족도")
                    Survey("컴포즈 스터디 난이도")
                    Survey("오늘 점심 메뉴 만족도")
                    Survey("솝트 만족도")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    },
                ) {
                    Text("제출하기")
                }
            },
        )
    }
}

@Composable
fun Survey(text: String) {
    val isMenuExpandedState = remember { mutableStateOf(false) }
    var selectedMenuItem = remember { mutableStateOf(0) }

    Row(modifier = Modifier.padding(10.dp)) {
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
            }
        }
    }
    ScoreStar(selectedMenuItem.value)
}

@Composable
fun ScoreStar(score: Int) {
    Row(modifier = Modifier.padding(horizontal = 5.dp, vertical = 6.dp)) {
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

@Composable
fun DropDownMenu(isMenuExpanded: MutableState<Boolean>, onMenuItemClick: (Int) -> Unit) {
    DropdownMenu(
        modifier = Modifier.wrapContentSize(),
        expanded = isMenuExpanded.value,
        onDismissRequest = { isMenuExpanded.value = false },
    ) {
        DropdownMenuItem(1, onMenuItemClick)
        DropdownMenuItem(2, onMenuItemClick)
        DropdownMenuItem(3, onMenuItemClick)
        DropdownMenuItem(4, onMenuItemClick)
        DropdownMenuItem(5, onMenuItemClick)
    }
}

// 점수 메뉴 아이템
@Composable
fun DropdownMenuItem(score: Int, onMenuItemClick: (Int) -> Unit) {
    DropdownMenuItem(
        { Text(text = score.toString()) },
        onClick = { onMenuItemClick(score) },
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Week3Theme {
        ScoreStar(5)
    }
}
