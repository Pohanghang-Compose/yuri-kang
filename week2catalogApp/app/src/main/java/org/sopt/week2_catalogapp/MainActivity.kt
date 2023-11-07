package org.sopt.week2_catalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    color = Color.Gray,
                ) {
                    CatalogAppPreview()
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
        item {
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
        val dataListState = remember { mutableStateOf(dataList) }

        dataList.forEach { data ->
            ItemCard(data)
        }

        ScrollList(dataListState)
    }
}
