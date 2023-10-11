package ru.studyguk.composetest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.studyguk.composetest.ui.theme.ComposeTestTheme

class MainActivity4 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Scaffold(
                    topBar = {
                        MakeTopBar()
                    },
                ) {
                    ShowResult()
                    AddRestartButton()
                }
            }
        }
    }

    @Composable
    private fun AddRestartButton() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 70.dp, top = 550.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val intent = Intent(
                        this@MainActivity4,
                        MainActivity3::class.java
                    )
                    startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                modifier = Modifier.size(height = 60.dp, width = 300.dp)
            ) {
                Text(text = "Пройти тест заново", fontSize = 18.sp)
            }
        }
    }

    @Composable
    private fun ShowResult() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Название теста",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 60.dp, start = 30.dp, end = 30.dp)
            )
            Text(
                text = "Баллы за тест",
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp)
            )
            Text(
                text = "Текстовый комментарий к результату теста",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    private fun MakeTopBar() {
        SmallTopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeTestTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Testing System")
                    }
                )
            },
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Название теста",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 60.dp, start = 30.dp, end = 30.dp)
                )
                Text(
                    text = "Баллы за тест",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp)
                )
                Text(
                    text = "Текстовый комментарий к результату теста",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp),
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 70.dp, top = 720.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                    modifier = Modifier.size(height = 60.dp, width = 300.dp)
                ) {
                    Text(text = "Пройти тест заново", fontSize = 18.sp)
                }
            }
        }
    }
}