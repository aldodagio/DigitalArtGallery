package com.example.businesscardapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface (
                modifier = Modifier
                    .fillMaxSize()
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                ) {
                    Gallery()
                }
            }
        }
    }
}
@Composable
fun Gallery() {
    var currentImageIndex by remember { mutableStateOf(0) }
    val images = listOf(
        R.drawable.artistunknown,
        R.drawable.dbz,
        R.drawable.deaaronfox,
        R.drawable.goku,
        R.drawable.kidgoku,
        R.drawable.mexicana,
        R.drawable.mexico,
        R.drawable.naruto,
        R.drawable.sacramentokings,
        R.drawable.sacramentokingslogo,
    )
    var artists = listOf(
        "Squidward Tentacles",
        "Dragonball Z",
        "De'Aaron Fox",
        "Goku",
        "Kid Goku",
        "Mexicana",
        "Mexican Art",
        "Naruto",
        "Sacramento Kings",
        "Sacramento Kings"
    )
    var years = listOf(
        "2001",
        "1991",
        "2023",
        "1995",
        "1988",
        "2015",
        "Unknown",
        "2012",
        "2023",
        "2023"
    )
    var titles = listOf(
        "Bold And Brash",
        "DBZ Fighting Squad",
        "Sacramento Kings Starting Point Guard",
        "Kakarot Glowing With His Kaioken Technique",
        "Young Son Kakarot",
        "Una Mexicana Pintada En El Pared",
        "Arte De Los Mexicano/a's De Antes",
        "Naruto Arrives In The Leaf To Defeat Pain",
        "Domantas Sabonis And Malik Monk During The 2022-2023 Season",
        "The Sacramento Kings Logo"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        ArtWall(painterResource(id = images[currentImageIndex]))
        Spacer(modifier = Modifier.height(100.dp))
        ArtTitle(titles[currentImageIndex], artists[currentImageIndex], years[currentImageIndex])
        Spacer(modifier = Modifier.height(30.dp))
        ButtonRow(
            onPreviousClick = {
                currentImageIndex = if (currentImageIndex == 0) images.size - 1 else currentImageIndex - 1
            },
            onNextClick = {
                currentImageIndex = (currentImageIndex + 1) % images.size
            }
        )
    }
}

@Composable
fun ButtonRow(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
)  {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = onPreviousClick,modifier = Modifier.width(120.dp)) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onNextClick,modifier = Modifier.width(120.dp)) {
            Text(text = "Next")
        }
    }
}
@Composable
fun ArtWall() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .align(Top)
                .height(400.dp)
                .width(300.dp)
                .background(Color.White)
                .shadow(4.dp, shape = RoundedCornerShape(8.dp))
        ){
            Image(painter = painterResource(id = R.drawable.artistunknown),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.align(Alignment.Center)
                .border(2.dp, Color.Black)
                .width(145.dp)
                .height(210.dp) )
        }
    }
}
@Composable
fun ArtWall(imagePainter: Painter) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .align(Top)
                .height(400.dp)
                .width(300.dp)
                .background(Color.White)
                .shadow(4.dp, shape = RoundedCornerShape(8.dp))
        ){
            Image(painter = imagePainter,
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Fit,
                modifier = Modifier.align(Alignment.Center)
                    .border(2.dp, Color.Black)
                    .width(145.dp)
                    .height(210.dp) )
        }
    }
}
@Composable
fun ArtTitle(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .align(CenterVertically)
                .height(110.dp)
                .width(300.dp)
                .background(Color.LightGray)
        ){
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Bold And Brash",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(1.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Squidward Tentacles",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "(2001)",
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun ArtTitle(title: String, artist: String, year: String){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .align(CenterVertically)
                .height(110.dp)
                .width(300.dp)
                .background(Color.LightGray)
        ){
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(1.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = artist,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "($year)",
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ArtGalleryPreview() {

    Surface (
            modifier = Modifier
                .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        ) {
            Gallery()
        }
    }
}

