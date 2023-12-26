package ru.studyguk.composetest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.studyguk.composetest.domain.usecases.OpenCatalogUseCase

class CatalogViewModel(private val openCatalogUseCase: OpenCatalogUseCase) : ViewModel() {
    private val _catalog = MutableLiveData<List<String>>()
    var catalog: LiveData<List<String>> = _catalog

    private val _testName = MutableLiveData<String>()
    var testName: LiveData<String> = _testName

    fun showCatalog() {
        viewModelScope.launch {
            _catalog.value = openCatalogUseCase.openCatalog()
        }
    }

    fun saveTestName(name: String) {
        _testName.value = name
    }
}