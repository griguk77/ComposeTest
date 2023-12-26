package ru.studyguk.composetest.domain.usecases

import ru.studyguk.composetest.domain.models.Question
import ru.studyguk.composetest.domain.repository.TestRepository

class ChooseTestUseCase(private val testRepository: TestRepository) {
    suspend fun chooseTest(testName: String): List<Question> {
        return testRepository.chooseTest(testName)
    }
}