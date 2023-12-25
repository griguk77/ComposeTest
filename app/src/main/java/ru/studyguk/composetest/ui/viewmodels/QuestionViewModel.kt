package ru.studyguk.composetest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.studyguk.composetest.domain.models.Question

class QuestionViewModel : ViewModel() {
    private val _queList = MutableLiveData<List<Question>>()
    var queList: LiveData<List<Question>> = _queList

//    private val _question = MutableLiveData<Question>()
//    var question: LiveData<Question> = _question

//    private val _queCount = MutableLiveData<Int>()
//    var queCount: LiveData<Int> = _queCount

    private val _pointsResult = MutableLiveData<Double>()
    var pointsResult: LiveData<Double> = _pointsResult

//    fun setQueNum(num: Int) {
//        _question.value?.queNum = num
//    }
//
//    fun getQueCount(name: String) {
//        _queCount.value = 3
//    }

//    fun getQuestion(name: String, num: Int) {
//        _question.value = queList.value?.get(num)
//    }

    fun setPoints(points: Double) {
        _pointsResult.value = points
    }

    fun getQueList(testName: String) {
        if (testName == "Математика") {
            _queList.value = listOf(
                Question(
                    1,
                    "Биссектриса - это ...",
                    listOf(
                        "Прямая, делящая угол пополам",
                        "Прямая, делящая сторону пополам",
                        "Центр пересечения перпендикуляров",
                        "Связанный набор параметров"
                    ),
                    listOf(
                        33.33,
                        -11.11,
                        -11.11,
                        -11.11
                    )
                ),
                Question(
                    2,
                    "Медиана - это ...",
                    listOf(
                        "Прямая, делящая угол пополам",
                        "Прямая, делящая сторону пополам",
                        "Центр пересечения перпендикуляров",
                        "Связанный набор параметров"
                    ),
                    listOf(
                        -11.11,
                        33.33,
                        -11.11,
                        -11.11
                    )
                ),
                Question(
                    3,
                    "2 + 2 * 2 = ?",
                    listOf(
                        "2",
                        "4",
                        "6",
                        "8"
                    ),
                    listOf(
                        -11.11,
                        -11.11,
                        33.34,
                        -11.12
                    )
                )
            )
        } else {
            _queList.value = listOf(
                Question(
                    1,
                    "Укажите слова, в которых заглавная буква является ударной",
                    listOf(
                        "ждАла",
                        "ободралА",
                        "созЫв",
                        "намЕрение"
                    ),
                    listOf(
                        -33.33,
                        11.11,
                        11.11,
                        11.11
                    )
                ),
                Question(
                    2,
                    "Укажите варианты, в которых у выделенных слов форма образована неверно",
                    listOf(
                        "об АЭРОПОРТЕ",
                        "по ИХ указанию",
                        "ЕДЬ побыстрее",
                        "уважаемые ДИРЕКТОРА"
                    ),
                    listOf(
                        -11.11,
                        -11.11,
                        33.33,
                        -11.11
                    )
                ),
                Question(
                    3,
                    "На хозяине была тка(1)ая рубаха, подпояса(2)ая кожа(3)ым ремнём, и " +
                            "давно не глаже(4)ые штаны. На месте каких цифр нужно поставить Н?",
                    listOf(
                        "1",
                        "2",
                        "3",
                        "4"
                    ),
                    listOf(
                        16.67,
                        -16.67,
                        16.67,
                        -16.67
                    )
                )
            )
        }
    }
}