package ru.studyguk.composetest.data.repository

import android.app.Application
import ru.studyguk.composetest.data.database.AppDatabase
import ru.studyguk.composetest.data.models.Test
import ru.studyguk.composetest.domain.models.Question
import ru.studyguk.composetest.domain.repository.TestRepository

class TestRepositoryImpl(private val application: Application) : TestRepository {
    private var db = AppDatabase.getInstance(application)

    override suspend fun chooseTest(testName: String): List<Question> {
        val questionList = db.testDao().getQueList(testName)
        return mapQuestionToDomain(questionList)
    }

    private fun mapQuestionToDomain(questionList: List<ru.studyguk.composetest.data.models.Question>): List<Question> {
        val resultList: MutableList<Question> = mutableListOf()
        for (question in questionList) {
            resultList.add(
                Question(
                    question.queNum,
                    question.queText,
                    listOf(
                        question.ans1,
                        question.ans2,
                        question.ans3,
                        question.ans4
                    ),
                    listOf(
                        question.point1,
                        question.point2,
                        question.point3,
                        question.point4
                    )
                )
            )
        }
        return resultList
    }

    override suspend fun openCatalog(): List<String> {
        if (db.testDao().getCatalog().isEmpty()) {
            db.testDao().insertTest(
                Test(
                    "Математика",
                    "Данный тест позволит оценить Ваши навыки в математике",
                    3
                )
            )
            db.testDao().insertTest(
                Test(
                    "Русский язык",
                    "Данный тест позволит оценить уровень Вашего владения русским языком",
                    3
                )
            )
            db.testDao().insertTest(
                Test(
                    "История",
                    "Данный тест позволит оценить Ваши знания истории",
                    3
                )
            )
            db.testDao().insertTest(
                Test(
                    "Химия",
                    "Данный тест позволит оценить Ваши знания о химии",
                    3
                )
            )
            db.testDao().insertTest(
                Test(
                    "Биология",
                    "Данный тест позволит оценить Ваш уровень знаний биологии",
                    3
                )
            )
            db.testDao().insertTest(
                Test(
                    "Политические координаты",
                    "Данный тест позволит оценить Вашу политическую предрасположенность",
                    3
                )
            )

            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    1,
                    "Математика",
                    1,
                    "Биссектриса - это ...",
                    "Прямая, делящая угол пополам",
                    "Прямая, делящая сторону пополам",
                    "Центр пересечения перпендикуляров",
                    "Связанный набор параметров",
                    33.33,
                    -11.11,
                    -11.11,
                    -11.11
                )
            )
            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    2,
                    "Математика",
                    2,
                    "Медиана - это ...",
                    "Прямая, делящая угол пополам",
                    "Прямая, делящая сторону пополам",
                    "Центр пересечения перпендикуляров",
                    "Связанный набор параметров",
                    -11.11,
                    33.33,
                    -11.11,
                    -11.11
                )
            )
            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    3,
                    "Математика",
                    3,
                    "2 + 2 * 2 = ?",
                    "2",
                    "4",
                    "6",
                    "8",
                    -11.11,
                    -11.11,
                    33.34,
                    -11.12
                )
            )

            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    4,
                    "Русский язык",
                    1,
                    "Укажите слова, в которых заглавная буква является ударной",
                    "ждАла",
                    "ободралА",
                    "созЫв",
                    "намЕрение",
                    -33.33,
                    11.11,
                    11.11,
                    11.11
                )
            )
            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    5,
                    "Русский язык",
                    2,
                    "Укажите варианты, в которых у выделенных слов форма образована неверно",
                    "об АЭРОПОРТЕ",
                    "по ИХ указанию",
                    "ЕДЬ побыстрее",
                    "уважаемые ДИРЕКТОРА",
                    11.11,
                    -11.11,
                    33.33,
                    -11.11
                )
            )
            db.testDao().insertQuestion(
                ru.studyguk.composetest.data.models.Question(
                    6,
                    "Русский язык",
                    3,
                    "На хозяине была тка(1)ая рубаха, подпояса(2)ая кожа(3)ым ремнём, и " +
                            "давно не глаже(4)ые штаны. На месте каких цифр нужно поставить Н?",
                    "1",
                    "2",
                    "3",
                    "4",
                    16.67,
                    -16.67,
                    16.67,
                    -16.67
                )
            )
        }
        return db.testDao().getCatalog()
    }
}