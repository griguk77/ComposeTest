package ru.studyguk.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.studyguk.composetest.ui.screens.CatalogScreen
import ru.studyguk.composetest.ui.screens.LoginScreen
import ru.studyguk.composetest.ui.screens.QuestionScreen
import ru.studyguk.composetest.ui.screens.ResultScreen
import ru.studyguk.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeTestTheme {
                NavHost(
                    navController = navController,
                    startDestination = LOGIN_SCREEN
                ) {
                    composable(LOGIN_SCREEN) {
                        LoginScreen {
                            navController.navigate(CATALOG_SCREEN) {
                                popUpTo(LOGIN_SCREEN)
                            }
                        }
                    }
                    composable(CATALOG_SCREEN) {
                        CatalogScreen(
                            onClick = {
                                navController.navigate(QUESTION_SCREEN) {
                                    popUpTo(CATALOG_SCREEN)
                                }
                            },
                            onTopBarClick = {
                                navController.navigate(LOGIN_SCREEN) {
                                    popUpTo(LOGIN_SCREEN) {
                                        inclusive = true
                                    }
                                }
                            },
                            applicationContext = applicationContext
                        )
                    }
                    composable(QUESTION_SCREEN) {
                        QuestionScreen(
                            onClick = {
                                navController.navigate(RESULT_SCREEN) {
                                    popUpTo(CATALOG_SCREEN)
                                }
                            },
                            onTopBarClick = {
                                navController.navigate(LOGIN_SCREEN) {
                                    popUpTo(LOGIN_SCREEN) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable(RESULT_SCREEN) {
                        ResultScreen(
                            onClick = {
                                navController.navigate(QUESTION_SCREEN) {
                                    popUpTo(CATALOG_SCREEN)
                                }
                            },
                            onTopBarClick = {
                                navController.navigate(LOGIN_SCREEN) {
                                    popUpTo(LOGIN_SCREEN) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    companion object {
        const val LOGIN_SCREEN = "login_screen"
        const val CATALOG_SCREEN = "catalog_screen"
        const val QUESTION_SCREEN = "question_screen"
        const val RESULT_SCREEN = "result_screen"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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
        var textName by remember {
            mutableStateOf("")
        }
        var textPassword by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Вход в систему",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 150.dp, bottom = 100.dp)
            )
            BasicTextField(
                value = textName,
                modifier = Modifier.padding(bottom = 40.dp),
                onValueChange = { textName = it },
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 64.dp)
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = Color(0xFF0042E7),
                                shape = RoundedCornerShape(size = 16.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                    ) {
                        if (textName.isEmpty()) {
                            Text(
                                text = "E-mail",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                        innerTextField()
                    }
                }
            )
            BasicTextField(
                value = textPassword,
                onValueChange = { textPassword = it },
                modifier = Modifier.padding(bottom = 60.dp),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 64.dp)
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                color = Color(0xFF0042E7),
                                shape = RoundedCornerShape(size = 16.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                    ) {
                        if (textName.isEmpty()) {
                            Text(
                                text = "Пароль",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier.size(height = 50.dp, width = 180.dp)
            ) {
                Text(text = "ВОЙТИ", fontSize = 20.sp)
            }
        }
    }
}