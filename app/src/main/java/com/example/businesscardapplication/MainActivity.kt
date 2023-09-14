package com.example.businesscardapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color(0x50, 0xAA, 0x50, 0x77))
                ) {
                    Column (modifier = Modifier
                        .fillMaxSize() // Take up the entire available space
                        .background(Color(0x50, 0xAA, 0x50, 0x77)),
                        verticalArrangement = Arrangement.Center, // Center vertically
                        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                         ){
                        BusinessImageRow()
                        Spacer(modifier = Modifier.height(80.dp))
                        NameTextRow()
                        Spacer(modifier = Modifier.height(10.dp))
                        NameTextRow()
                        Spacer(modifier = Modifier.height(8.dp))
                        PhoneTextRow()
                        Spacer(modifier = Modifier.height(8.dp))
                        EmailTextRow()
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
        }
    }
}

@Composable
fun BusinessImageRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = stringResource(id = R.string.app_name)
        )
    }
}
@Composable
fun PhoneTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.phone),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Phone Number: (916) 517 - 9142")
    }
}
@Composable
fun NameTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Aldo Dagio-Ortega", fontWeight = FontWeight.Bold)
    }
}
@Composable
fun SchoolTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Computer Science Student at Long Beach State")
    }
}
@Composable
fun EmailTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.mail),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Email: aldo.dagio-ortega01@student.csulb.edu")
    }
}
@Composable
fun LinkedInTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.linkedin),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "LinkedIn: www.linkedin.com/in/aldo-dagio-9696b7158/")
    }
}
@Composable
fun GitHubTextRow() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.github),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "GitHub: https://github.com/aldodagio")
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize() // Take up the entire available space
            .background(Color(0x50, 0xAA, 0x50, 0x77)),
        verticalArrangement = Arrangement.Center, // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
    ) {
        BusinessImageRow()
        Spacer(modifier = Modifier.height(10.dp))
        NameTextRow()
        Spacer(modifier = Modifier.height(10.dp))
        SchoolTextRow()
        Spacer(modifier = Modifier.height(300.dp))
        PhoneTextRow()
        Spacer(modifier = Modifier.height(8.dp))
        EmailTextRow()
        Spacer(modifier = Modifier.height(8.dp))
        GitHubTextRow()
        Spacer(modifier = Modifier.height(8.dp))
        LinkedInTextRow()
        Spacer(modifier = Modifier.height(8.dp))
    }
}

