package ru.studyguk.composetest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _textResult = MutableLiveData<String>()
    var textResult: LiveData<String> = _textResult

    fun setTextResult(points: Double) {
        if (points >= 50.0) {
            _textResult.value = "Вы молодец!"
        } else {
            _textResult.value = "Какой ужас!"
        }
    }
}