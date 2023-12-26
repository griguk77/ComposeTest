package ru.studyguk.composetest.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.studyguk.composetest.data.repository.TestRepositoryImpl
import ru.studyguk.composetest.domain.usecases.OpenCatalogUseCase

class CatalogViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    private val testRepository by lazy(LazyThreadSafetyMode.NONE) {
        TestRepositoryImpl(application)
    }

    private val openCatalogUseCase by lazy(LazyThreadSafetyMode.NONE) {
        OpenCatalogUseCase(testRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogViewModel(openCatalogUseCase) as T
    }
}