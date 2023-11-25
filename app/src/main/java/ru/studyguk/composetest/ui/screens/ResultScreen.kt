package ru.studyguk.composetest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(onClick: () -> Unit, onTopBarClick: () -> Unit) {
    Scaffold(
        topBar = {
            MakeTopBar(onTopBarClick)
        },
    ) {
        ShowResult()
        AddRestartButton(onClick)
    }
}

@Composable
private fun AddRestartButton(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 70.dp, top = 550.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onClick()
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
private fun MakeTopBar(onTopBarClick: () -> Unit) {
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
                onTopBarClick()
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(ru.studyguk.composetest.R.drawable.ic_baseline_logout_24),
                    contentDescription = "Logout"
                )
            }
        }
    )
}