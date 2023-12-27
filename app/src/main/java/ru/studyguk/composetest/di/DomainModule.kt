package ru.studyguk.composetest.di

import org.koin.dsl.module
import ru.studyguk.composetest.domain.usecases.ChooseTestUseCase
import ru.studyguk.composetest.domain.usecases.OpenCatalogUseCase

val domainModule = module {

    factory<OpenCatalogUseCase> {
        OpenCatalogUseCase(testRepository = get())
    }

    factory<ChooseTestUseCase> {
        ChooseTestUseCase(testRepository = get())
    }
}