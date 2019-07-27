package com.grayimediary.archimedescalculator.models

data class CalcExpression(
    val expr: String,
    val answer: String,
    val selectionStart: Int,
    val selectionEnd: Int
)