package org.sopt.week2_catalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.week2_catalogapp.ui.theme.Week2catalogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week2catalogAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val dataList =
                        listOf(
                            Data(
                                title = "Title 1",
                                content = "Description 1",
                                image = R.drawable.img_ham1,
                            ),
                            Data(
                                title = "Title 2",
                                content = "Description 2",
                                image = R.drawable.img_ham2,
                            ),
                            Data(
                                title = "Title 3",
                                content = "Description 3",
                                image = R.drawable.img_ham3,
                            ),
                            Data(
                                title = "Title 4",
                                content = "Description 4",
                                image = R.drawable.img_ham4,
                            ),
                            Data(
                                title = "Title 5",
                                content = "Description 5",
                                image = R.drawable.img_ham5,
                            ),
                        )

                    dataList.forEach { data ->
                        ItemCard(data)
                    }

                    val dataListState = remember { mutableStateOf(dataList) }

                    dataList.forEach { data ->
                        ItemCard(data)
                    }

                    ScrollList(dataListState)
                }
            }
        }
    }
}

@Composable
fun ScrollList(data: State<List<Data>?>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 30.dp),
    ) {
        // Header item
        item {
            // 이 부분에 헤더 컨텐츠를 추가합니다.
            Spacer(modifier = Modifier.height(16.dp))
        }

        data.value?.let {
            items(it) { item ->
                ItemCard(item)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CatalogAppPreview() {
    Week2catalogAppTheme {
        val dataList =
            listOf(
                Data(
                    title = "Title 1",
                    content = "Description 1",
                    image = R.drawable.img_ham1,
                ),
                Data(
                    title = "Title 2",
                    content = "Description 2",
                    image = R.drawable.img_ham2,
                ),
                Data(
                    title = "Title 3",
                    content = "Description 3",
                    image = R.drawable.img_ham3,
                ),
                Data(
                    title = "Title 4",
                    content = "Description 4",
                    image = R.drawable.img_ham4,
                ),
                Data(
                    title = "Title 5",
                    content = "Description 5",
                    image = R.drawable.img_ham5,
                ),
            )

        val dataListState = remember { mutableStateOf(dataList) }

        dataList.forEach { data ->
            ItemCard(data)
        }

        ScrollList(dataListState)
    }
}
