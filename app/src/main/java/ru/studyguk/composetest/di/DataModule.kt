package ru.studyguk.composetest.di

import org.koin.dsl.module
import ru.studyguk.composetest.data.repository.TestRepositoryImpl
import ru.studyguk.composetest.domain.repository.TestRepository

val dataModule = module {

    single<TestRepository> {
        TestRepositoryImpl(application = get())
    }
}