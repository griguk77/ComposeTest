package ru.studyguk.composetest.domain.models

data class Result(
    var testName: String,
    var userName: String,
    var points: Double,
    var date: String
)