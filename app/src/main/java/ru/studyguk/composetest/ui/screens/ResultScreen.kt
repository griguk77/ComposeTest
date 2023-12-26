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
import ru.studyguk.composetest.ui.viewmodels.CatalogViewModel
import ru.studyguk.composetest.ui.viewmodels.QuestionViewModel
import ru.studyguk.composetest.ui.viewmodels.ResultViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    catalogVM: CatalogViewModel,
    questionVM: QuestionViewModel,
    resultVM: ResultViewModel,
    onClick: () -> Unit,
    onTopBarClick: () -> Unit
) {
    Scaffold(
        topBar = {
            MakeTopBar(onTopBarClick)
        },
    ) {
        ShowResult(catalogVM, questionVM, resultVM)
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
private fun ShowResult(
    catalogVM: CatalogViewModel,
    questionVM: QuestionViewModel,
    resultVM: ResultViewModel
) {
    questionVM.pointsResult.value?.let { resultVM.setTextResult(it) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        catalogVM.testName.value?.let {
            Text(
                text = it,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 60.dp, start = 30.dp, end = 30.dp)
            )
        }
        Text(
            text = "${questionVM.pointsResult.value}",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 50.dp, start = 30.dp, end = 30.dp)
        )
        Text(
            text = "${resultVM.textResult.value}",
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