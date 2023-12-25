package ru.studyguk.composetest.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.studyguk.composetest.ui.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(loginVM: LoginViewModel, onClick: () -> Unit) {
    Scaffold(
        topBar = {
            MakeBasicTopBar()
        }
    )
    {
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
            SetLoginText()
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
                                color = MaterialTheme.colorScheme.primary,
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
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(size = 16.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                    ) {
                        if (textPassword.isEmpty()) {
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
            SetLoginButton(onClick, textName, loginVM)
        }
    }
}

@Composable
private fun MakeBasicTopBar() {
    SmallTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("Testing System")
        }
    )
}

@Composable
private fun SetLoginButton(onClick: () -> Unit, textName: String, loginVM: LoginViewModel) {
    Button(
        onClick = {
            loginVM.login(textName)
            onClick()
        },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        modifier = Modifier.size(height = 50.dp, width = 180.dp)
    ) {
        Text(text = "ВОЙТИ", fontSize = 20.sp)
    }
}

@Composable
private fun SetLoginText() {
    Text(
        text = "Вход в систему",
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 150.dp, bottom = 100.dp)
    )
}