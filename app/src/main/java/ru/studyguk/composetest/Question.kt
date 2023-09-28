package ru.studyguk.composetest

data class Question(
    var queNum: Int,
    var queText: String,
    var variants: List<String>
)
