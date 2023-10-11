package ru.studyguk.composetest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.bottomappbar.BottomAppBar
import ru.studyguk.composetest.ui.theme.ComposeTestTheme


class MainActivity2 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                Scaffold(
                    topBar = {
                        MakeTopBar()
                    },
                    floatingActionButton = {
                        MakeFAB()
                    }
                ) {
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
    }

    @Composable
    private fun MakeFAB() {
        FloatingActionButton(
            onClick = {
                Toast.makeText(
                    applicationContext,
                    "Плоти налоги",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(ImageVector.vectorResource(R.drawable.ic_baseline_add_24), "Add")
        }
    }

    @Composable
    private fun MakeTopBar() {
        SmallTopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
            title = {
                Text("Testing System")
            },
            navigationIcon = {
                IconButton(onClick = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_logout_24),
                        contentDescription = "Logout"
                    )
                }
            }
        )
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


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Testing System")
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_logout_24),
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(16.dp),
            ) {
                Icon(ImageVector.vectorResource(R.drawable.ic_baseline_add_24), "Add")
            }
        }
    ) {
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
}