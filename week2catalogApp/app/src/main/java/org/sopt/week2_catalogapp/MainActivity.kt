package org.sopt.week2_catalogapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.sopt.week2_catalogapp.ui.theme.Week2catalogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week2catalogAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    BottomAppBarEx()
                }
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val canvasSize = size

        drawCircle(
            color = Color.Blue,
            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
            radius = size.minDimension / 4,
        )

        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue,
            strokeWidth = 5F,
        )

        withTransform({
            translate(left = canvasWidth / 5F)
            rotate(degrees = 45F)
        }) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = canvasWidth / 3F, y = canvasHeight / 3F),
                size = canvasSize / 3F,
            )
        }

        val arcRect = Rect(top = 50f, left = 50f, right = 150f, bottom = 150f)
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = arcRect.topLeft,
            size = Size(arcRect.width, arcRect.height),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                },
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                },
            ) {
                Text("Dismiss")
            }
        },
    )
}

@Composable
fun MinimalDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp),
                )
                Text(
                    text = "다이얼로그 설명임",
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}

@Composable
fun DropdouwnMenuEx() {
    DropdownMenu(
        modifier = Modifier.wrapContentSize(),
        expanded = true,
        onDismissRequest = { /*TODO*/ },
    ) {
        DropdownMenuItem({ Text(text = "아이템1") }, onClick = { print("아이템 1 클릭") })
        DropdownMenuItem({ Text(text = "아이템2") }, onClick = { print("아이템 2 클릭") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackbarExample() {
    var snackbarVisible by remember { mutableStateOf(false) } // 스낵바 표시 여부를 추적하는 상태
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Button(
                    onClick = {
                        // 스낵바를 표시하도록 상태를 변경
                        snackbarVisible = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Show Snackbar")
                }
            }
        },

        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.Gray,
                contentColor = Color.White,
                tonalElevation = 8.dp,
                contentPadding = PaddingValues(16.dp),
                windowInsets = WindowInsets(10.dp),
            ) {
                // 바텀 앱바 내부 콘텐츠
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Custom Bottom AppBar",
                        style = TextStyle(fontWeight = FontWeight.Bold),
                    )
                    IconButton(onClick = { /* 액션 처리 */ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            }
        },
    )

    // 스낵바 표시 여부에 따라 스낵바를 표시
    if (snackbarVisible) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            action = {
                TextButton(
                    onClick = {
                        // 스낵바를 닫도록 상태를 변경
                        snackbarVisible = false
                    },
                    modifier = Modifier.padding(10.dp),
                ) {
                    Text("Dismiss")
                }
            },
        ) {
            Text(text = "This is a Snackbar message")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarEx() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = Color.Gray,
                contentColor = Color.White,
                tonalElevation = 8.dp,
                contentPadding = PaddingValues(0.dp),
                windowInsets = WindowInsets(20.dp),
            ) {
                // 바텀 앱바 내부 콘텐츠
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "아이콘1",
                        style = TextStyle(fontWeight = FontWeight.ExtraBold),
                    )
                    IconButton(onClick = { /* 액션 처리 */ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                    }
                    IconButton(onClick = { /* 액션 처리 */ }) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Settings")
                    }
                    IconButton(onClick = { /* 액션 처리 */ }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Settings")
                    }
                }
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
            }
        },

    ) {
        //
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExamplePreview() {
    Week2catalogAppTheme {
//        AlertDialogExample(
//            onDismissRequest = {
//                // 다이얼로그를 닫을 때 실행할 동작을 여기에 추가
//            },
//            onConfirmation = {
//                // 확인 버튼 클릭 시 실행할 동작을 여기에 추가
//            },
//            dialogTitle = "다이얼로그 타이틀 ~",
//            dialogText = "다이얼로그 예제 코드 ~ !!!!!!!!!!!!!!!!! 엄청 ㄹ길게 하면 어디까지 내려가는지 볼까요 이거 어디까지 내려가는 거예요 예? 아 그냥 다이얼로그 길이가 세로로 길어지는군요",
//            icon = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
//        )

//        MinimalDialog(onDismissRequest = {
//            // 다이얼로그를 닫을 때 실행할 동작을 여기에 추가
//        })
//
//        DialogWithImage(
//            onDismissRequest = {
//                // 다이얼로그를 닫을 때 실행할 동작을 여기에 추가
//            },
//            onConfirmation = {
//                // 확인 버튼 클릭 시 실행할 동작을 여기에 추가
//            },
//            painter = painterResource(id = R.drawable.img_yeah),
//            imageDescription = "이미지 있는 다이얼로그",
//        )
        BottomAppBarEx()
    }
}
