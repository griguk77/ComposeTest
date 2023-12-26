package ru.studyguk.composetest.domain.repository

import androidx.lifecycle.LiveData
import ru.studyguk.composetest.domain.models.Question

interface TestRepository {

    suspend fun chooseTest(testName: String): List<Question>

    suspend fun openCatalog(): List<String>
}