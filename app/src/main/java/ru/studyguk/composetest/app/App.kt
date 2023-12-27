package ru.studyguk.composetest.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.studyguk.composetest.di.appModule
import ru.studyguk.composetest.di.dataModule
import ru.studyguk.composetest.di.domainModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}