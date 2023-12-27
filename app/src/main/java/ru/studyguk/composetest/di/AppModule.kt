package ru.studyguk.composetest.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.studyguk.composetest.ui.viewmodels.CatalogViewModel
import ru.studyguk.composetest.ui.viewmodels.LoginViewModel
import ru.studyguk.composetest.ui.viewmodels.QuestionViewModel
import ru.studyguk.composetest.ui.viewmodels.ResultViewModel

val appModule = module {

    viewModel<LoginViewModel> {
        LoginViewModel()
    }

    viewModel<CatalogViewModel> {
        CatalogViewModel(openCatalogUseCase = get())
    }

    viewModel<QuestionViewModel> {
        QuestionViewModel(chooseTestUseCase = get())
    }

    viewModel<ResultViewModel> {
        ResultViewModel()
    }
}