package ru.studyguk.composetest.ui.screens

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.studyguk.composetest.ui.viewmodels.CatalogViewModel
import ru.studyguk.composetest.ui.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    loginVM: LoginViewModel,
    catalogVM: CatalogViewModel,
    onClick: () -> Unit,
    onTopBarClick: () -> Unit,
    applicationContext: Context
) {
    catalogVM.showCatalog()
    val testList = catalogVM.catalog.value
    Scaffold(
        topBar = {
            MakeTopBar(onTopBarClick)
        },
        floatingActionButton = {
            MakeFAB(applicationContext)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetGreetingsText(loginVM)
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 30.dp)
            ) {
                if (testList != null) {
                    items(testList.size) {
                        SetTestItem(catalogVM, testList, it, onClick)
                    }
                }
            }
        }
    }
}

@Composable
private fun MakeFAB(applicationContext: Context) {
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
        Icon(
            ImageVector.vectorResource(ru.studyguk.composetest.R.drawable.ic_baseline_add_24),
            "Add"
        )
    }
}

@Composable
private fun MakeTopBar(onTopBarClick: () -> Unit) {
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

@Composable
private fun SetTestItem(catalogVM: CatalogViewModel, testList: List<String>, it: Int, onClick: () -> Unit) {
    Text(
        text = testList[it],
        fontSize = 24.sp,
        modifier = Modifier
            .size(height = 90.dp, width = 10000.dp)
            .clickable(onClick = {
                catalogVM.saveTestName(testList[it])
                onClick()
            }),
        style = TextStyle(textDecoration = TextDecoration.Underline)
    )
}

@Composable
private fun SetGreetingsText(loginVM: LoginViewModel) {
    Text(
        text = "Здравствуйте, ${loginVM.userName.value}!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 60.dp, bottom = 40.dp)
    )
}