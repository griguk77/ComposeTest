package ru.studyguk.composetest.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.studyguk.composetest.domain.models.Question
import ru.studyguk.composetest.ui.theme.ComposeTestTheme
import ru.studyguk.composetest.ui.viewmodels.CatalogViewModel
import ru.studyguk.composetest.ui.viewmodels.QuestionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(catalogVM: CatalogViewModel, questionVM: QuestionViewModel, onClick: () -> Unit, onTopBarClick: () -> Unit) {
    catalogVM.testName.value?.let { questionVM.getQueList(it) }
    val queList = questionVM.queList.value
    questionVM.setPoints(0.0)
    Scaffold(
        topBar = {
            MakeTopBar(onTopBarClick)
        },
    ) {
        val currentQueNum = remember { mutableStateOf(0) }
        val btnText = remember { mutableStateOf("Продолжить") }
        val checkedState0 = remember { mutableStateOf(false) }
        val checkedState1 = remember { mutableStateOf(false) }
        val checkedState2 = remember { mutableStateOf(false) }
        val checkedState3 = remember { mutableStateOf(false) }
        ComposeTestTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SetTestName(catalogVM)
                if (queList != null) {
                    SetProgress(queList, currentQueNum)
                }
                if (queList != null) {
                    SetQuestionText(queList, currentQueNum)
                }
                if (queList != null) {
                    SetVariants(
                        currentQueNum,
                        queList,
                        checkedState0,
                        checkedState1,
                        checkedState2,
                        checkedState3
                    )
                }
            }
            if (queList != null) {
                SetContinueButton(
                    queList,
                    questionVM,
                    currentQueNum,
                    btnText,
                    checkedState0,
                    checkedState1,
                    checkedState2,
                    checkedState3,
                    onClick
                )
            }
        }
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

@Composable
private fun SetContinueButton(
    queList: List<Question>,
    questionVM: QuestionViewModel,
    currentQueNum: MutableState<Int>,
    btnText: MutableState<String>,
    checkedState0: MutableState<Boolean>,
    checkedState1: MutableState<Boolean>,
    checkedState2: MutableState<Boolean>,
    checkedState3: MutableState<Boolean>,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp, top = 600.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                var pointResult = 0.0
                if (checkedState0.value) {
                    pointResult += queList[currentQueNum.value].points[0]
                }
                if (checkedState1.value) {
                    pointResult += queList[currentQueNum.value].points[1]
                }
                if (checkedState2.value) {
                    pointResult += queList[currentQueNum.value].points[2]
                }
                if (checkedState3.value) {
                    pointResult += queList[currentQueNum.value].points[3]
                }
                questionVM.setPoints(pointResult + (questionVM.pointsResult.value ?: 0.0))
                if (currentQueNum.value == 1) {
                    btnText.value = "Закончить тест"
                }
                if (currentQueNum.value == 2) {
                    onClick()
                } else {
                    currentQueNum.value++
                }
                checkedState0.value = false
                checkedState1.value = false
                checkedState2.value = false
                checkedState3.value = false
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = Modifier.size(height = 60.dp, width = 200.dp)
        ) {
            Text(text = btnText.value, fontSize = 20.sp)
        }
    }
}

@Composable
private fun SetVariants(
    currentQueNum: MutableState<Int>,
    queList: List<Question>,
    checkedState0: MutableState<Boolean>,
    checkedState1: MutableState<Boolean>,
    checkedState2: MutableState<Boolean>,
    checkedState3: MutableState<Boolean>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState0.value,
            onCheckedChange = { checkedState0.value = it },
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
        )
        Text(
            text = queList[currentQueNum.value].variants[0],
            fontSize = 18.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState1.value,
            onCheckedChange = { checkedState1.value = it },
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
        )
        Text(
            text = queList[currentQueNum.value].variants[1],
            fontSize = 18.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState2.value,
            onCheckedChange = { checkedState2.value = it },
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
        )
        Text(
            text = queList[currentQueNum.value].variants[2],
            fontSize = 18.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState3.value,
            onCheckedChange = { checkedState3.value = it },
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
        )
        Text(
            text = queList[currentQueNum.value].variants[3],
            fontSize = 18.sp
        )
    }
}

@Composable
private fun SetProgress(
    queList: List<Question>,
    currentQueNum: MutableState<Int>
) {
    Text(
        text = "${queList[currentQueNum.value].queNum}/${queList.size}",
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        modifier = Modifier.padding(top = 20.dp, start = 280.dp)
    )
}

@Composable
private fun SetQuestionText(
    queList: List<Question>,
    currentQueNum: MutableState<Int>
) {
    Text(
        text = queList[currentQueNum.value].queText,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
private fun SetTestName(catalogVM: CatalogViewModel) {
    catalogVM.testName.value?.let {
        Text(
            text = it,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

//private fun getQuestionList(): List<Question> {
//    return listOf(
//        Question(
//            1,
//            "Биссектриса - это ...",
//            listOf(
//                "Прямая, делящая угол пополам",
//                "Прямая, делящая сторону пополам",
//                "Центр пересечения перпендикуляров",
//                "Связанный набор параметров"
//            ),
//            listOf(
//                12.5,
//                -4.16,
//                -4.17,
//                -4.17
//            )
//        ),
//        Question(
//            2,
//            "Медиана - это ...",
//            listOf(
//                "Прямая, делящая угол пополам",
//                "Прямая, делящая сторону пополам",
//                "Центр пересечения перпендикуляров",
//                "Связанный набор параметров"
//            ),
//            listOf(
//                -4.16,
//                12.5,
//                -4.17,
//                -4.17
//            )
//        ),
//        Question(
//            3,
//            "2 + 2 * 2 = ?",
//            listOf(
//                "2",
//                "4",
//                "6",
//                "8"
//            ),
//            listOf(
//                -4.16,
//                -4.17,
//                12.5,
//                -4.17
//            )
//        )
//    )
//}