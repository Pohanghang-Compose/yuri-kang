package org.sopt.week1_profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.week1_profilecard.ui.theme.Week1profileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week1profileCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .background(color = Color.White),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    profileCard()
                }
            }
        }
    }
}

@Composable
fun profileCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(30.dp, 30.dp)
            .background(
                Color(0xFFFAC025),
            ),
    ) {
        Text(
            text = "IDENTIFICATION CARD",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize()
                .background(
                    Color.White,
                ),
        ) {
            Image(
                painter = painterResource(R.drawable.profile_image),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 40.dp),
            )

            Text(
                text = "SHIN JJangu",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Normal,
                modifier = Modifier
                    .padding(top = 25.dp),
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
            Text(
                text = "{ Leviathan }",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(top = 5.dp, bottom = 40.dp),
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "BREED",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 70.dp),
                    color = Color.Black,
                    fontSize = 18.sp,

                )
                Text(
                    text = "PURE",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 110.dp),
                    color = Color.Gray,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,

                )
            }
            Divider(
                color = Color(0xFFFAC025),
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 1.dp),
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "SYNDROME",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 53.dp),
                    color = Color.Black,
                    fontSize = 18.sp,

                )
                Text(
                    text = "SOLARIS",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 98.dp),
                    color = Color.Gray,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,

                )
            }
            Divider(color = Color(0xFFFAC025), modifier = Modifier.padding(horizontal = 40.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "WORKS",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 70.dp),
                    color = Color.Black,
                    fontSize = 18.sp,

                )
                Text(
                    text = "UGN JAPAN BRANCH CHIEF",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(end = 50.dp),
                    color = Color.Gray,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,

                )
            }
            Divider(
                color = Color(0xFFFAC025),
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp, top = 1.dp, bottom = 40.dp),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .padding(top = 70.dp)
                    .size(80.dp),

            )

            Text(
                text = "UNIVERSAL GUARDIANS NETWORK",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(top = 100.dp, end = 10.dp),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
fun PreViewMessageCard() {
    Week1profileCardTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            profileCard()
        }
    }
}
