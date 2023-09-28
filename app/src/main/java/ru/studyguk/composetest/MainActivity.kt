package ru.studyguk.composetest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
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
                    SetLoginButton()
                }
            }
        }
    }

    @Composable
    private fun SetLoginButton() {
        Button(
            onClick = {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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