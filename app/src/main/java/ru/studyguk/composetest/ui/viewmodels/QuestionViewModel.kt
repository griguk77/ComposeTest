package ru.studyguk.composetest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.studyguk.composetest.domain.models.Question
import ru.studyguk.composetest.domain.usecases.ChooseTestUseCase

class QuestionViewModel(private val chooseTestUseCase: ChooseTestUseCase) : ViewModel() {
    private val _queList = MutableLiveData<List<Question>>()
    var queList: LiveData<List<Question>> = _queList

    private val _pointsResult = MutableLiveData<Double>()
    var pointsResult: LiveData<Double> = _pointsResult

    fun setPoints(points: Double) {
        _pointsResult.value = points
    }

    fun getQueList(testName: String) {
        viewModelScope.launch {
            _queList.value = chooseTestUseCase.chooseTest(testName)
        }
    }
}