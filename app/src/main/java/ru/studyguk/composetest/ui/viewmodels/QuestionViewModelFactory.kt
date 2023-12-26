package ru.studyguk.composetest.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.studyguk.composetest.data.repository.TestRepositoryImpl
import ru.studyguk.composetest.domain.usecases.ChooseTestUseCase

class QuestionViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    private val testRepository by lazy(LazyThreadSafetyMode.NONE) {
        TestRepositoryImpl(application)
    }

    private val chooseTestUseCase by lazy(LazyThreadSafetyMode.NONE) {
        ChooseTestUseCase(testRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuestionViewModel(chooseTestUseCase) as T
    }
}