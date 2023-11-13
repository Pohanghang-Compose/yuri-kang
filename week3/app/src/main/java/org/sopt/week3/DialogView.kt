package org.sopt.week3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week3.ui.theme.Week3Theme

@Composable
fun SurveyDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        // 설문조사 하기 버튼
        SurveyBtn(onClick = { showDialog = true })

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
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
                            showDialog = false
                        },
                    ) {
                        Text("제출하기")
                    }
                },
            )
        }
    }
}

@Composable
fun Survey(text: String) {
    val isMenuExpandedState = remember { mutableStateOf(false) }
    // var isMenuExpanded by isMenuExpandedState

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
            )

            // 메뉴
            DropDownMenu(isMenuExpandedState)
        }
    }
}

@Composable
fun DropDownMenu(isMenuExpanded: MutableState<Boolean>) {
    DropdownMenu(
        modifier = Modifier.wrapContentSize(),
        expanded = isMenuExpanded.value,
        onDismissRequest = { isMenuExpanded.value = false },
    ) {
        DropdownMenuItem(1)
        DropdownMenuItem(2)
        DropdownMenuItem(3)
        DropdownMenuItem(4)
        DropdownMenuItem(5)
    }
}

// 점수 메뉴 아이템
@Composable
fun DropdownMenuItem(score: Int) {
    DropdownMenuItem({ Text(text = score.toString()) }, onClick = { print("아이템 1 클릭") })
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Week3Theme {
        SurveyDialog()
    }
}
