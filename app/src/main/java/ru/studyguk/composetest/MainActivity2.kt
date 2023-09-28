package ru.studyguk.composetest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ComposeTestTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testList = listOf(
            "Биология",
            "История",
            "Математика",
            "Политические координаты",
            "Русский язык",
            "Химия"
        )
        setContent {
            ComposeTestTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SetGreetingsText()
                    LazyColumn(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(start = 30.dp)
                    ) {
                        items(testList.size) {
                            SetTestItem(testList, it)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun SetTestItem(testList: List<String>, it: Int) {
        Text(
            text = testList[it],
            fontSize = 24.sp,
            modifier = Modifier
                .size(height = 90.dp, width = 10000.dp)
                .clickable(onClick = {
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                }),
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
    }

    @Composable
    private fun SetGreetingsText() {
        Text(
            text = "Здравствуйте, Пользователь!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp, bottom = 40.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val testList = listOf(
        "Биология",
        "История",
        "Математика",
        "Политические координаты",
        "Русский язык",
        "Химия"
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Здравствуйте, Пользователь!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp, bottom = 40.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 30.dp)
        ) {
            items(testList.size) {
                Text(
                    text = testList[it],
                    fontSize = 24.sp,
                    modifier = Modifier.size(height = 90.dp, width = 10000.dp),
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
            }
        }
    }
}