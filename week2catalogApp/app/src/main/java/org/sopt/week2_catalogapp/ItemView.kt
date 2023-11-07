package org.sopt.week2_catalogapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import org.sopt.week2_catalogapp.ui.theme.Week2catalogAppTheme

@Composable
fun ItemCard(data: Data) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        border = BorderStroke(2.dp, color = Color.DarkGray),
    ) {
        ItemImage(
            imageResource = data.image,
            content = data.title,
        )
        ItemTitle(data.title)
        ItemContent(data.content)
    }
}

@Composable
fun ItemImage(imageResource: Int, content: String) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(10.dp)
    ) {
        val painter =
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageResource)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.img_holder)
                        error(R.drawable.img_error)
                    }).build(),
            )

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = content,
        )
    }
}

@Composable
fun ItemTitle(title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentWidth().padding(horizontal = 5.dp),
    ) {
        Text(
            text = title,
            modifier =
            Modifier.padding(horizontal = 10.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun ItemContent(content: String) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.wrapContentWidth().padding(horizontal = 5.dp),

    ) {
        Text(
            text = content,
            modifier =
            Modifier.padding(10.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.DarkGray,
        )
    }
}

@Preview
@Composable
fun PreviewItem() {
    Week2catalogAppTheme {
        dataList.forEach { data ->
            ItemCard(data)
        }
    }
}
