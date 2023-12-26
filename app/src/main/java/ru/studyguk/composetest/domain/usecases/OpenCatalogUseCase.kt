package ru.studyguk.composetest.domain.usecases

import ru.studyguk.composetest.domain.repository.TestRepository

class OpenCatalogUseCase(private val testRepository: TestRepository) {
    suspend fun openCatalog(): List<String> {
        return testRepository.openCatalog()
    }
}