package ru.studyguk.composetest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatalogViewModel : ViewModel() {
    private val _catalog = MutableLiveData<List<String>>()
    var catalog: LiveData<List<String>> = _catalog

    private val _testName = MutableLiveData<String>()
    var testName: LiveData<String> = _testName

    fun showCatalog() {
        _catalog.value = listOf(
            "Биология",
            "История",
            "Математика",
            "Политические координаты",
            "Русский язык",
            "Химия"
        )
    }

    fun saveTestName(name: String) {
        _testName.value = name
    }
}