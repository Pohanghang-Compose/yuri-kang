package org.sopt.week2_catalogapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
    Column(
        modifier = Modifier.wrapContentSize(),
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
        modifier = Modifier.wrapContentWidth(),
    ) {
        Text(
            text = title,
            modifier =
            Modifier.padding(10.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun ItemContent(content: String) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.wrapContentWidth(),

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
    }
}
