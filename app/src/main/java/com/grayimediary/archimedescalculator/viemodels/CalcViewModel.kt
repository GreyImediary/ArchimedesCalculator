package com.grayimediary.archimedescalculator.viemodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grayimediary.archimedescalculator.algorithms.resultOf
import com.grayimediary.archimedescalculator.common.constants.INFINITY
import com.grayimediary.archimedescalculator.common.constants.WRONG_EXPRESSION
import com.grayimediary.archimedescalculator.models.CalcExpression

class CalcViewModel : ViewModel() {
    val calcExpression: MutableLiveData<CalcExpression> by lazy {
        MutableLiveData(CalcExpression("", "0", 0, 0))
    }

    fun addSymbol(oldCalcExpression: CalcExpression, newSymbol: String) {
        val newExpr = oldCalcExpression.expr.replaceRange(
            oldCalcExpression.selectionStart,
            oldCalcExpression.selectionEnd,
            newSymbol
        )
        val newAnswer = resultOf(newExpr)
        val newSelectionStart: Int
        val newSelectionEnd: Int

        if (oldCalcExpression.selectionStart == oldCalcExpression.selectionEnd) {
            newSelectionStart = oldCalcExpression.selectionStart + 1
            newSelectionEnd = oldCalcExpression.selectionEnd + 1
        } else {
            newSelectionStart = oldCalcExpression.selectionStart + 1
            newSelectionEnd = newSelectionStart
        }

        calcExpression.value = CalcExpression(newExpr, newAnswer, newSelectionStart, newSelectionEnd)
    }

    fun clearExpression() {
        calcExpression.value = CalcExpression("", "0", 0, 0)
    }

    fun removeSymbol(oldCalcExpression: CalcExpression) {

        if (oldCalcExpression.expr.isEmpty() ||
            (oldCalcExpression.selectionStart == oldCalcExpression.selectionEnd
                    && oldCalcExpression.selectionStart == 0)) {
            return
        }

        val newExpr: String
        val newAnswer: String
        val newSelectionStart: Int

        newExpr = if (oldCalcExpression.selectionStart == oldCalcExpression.selectionEnd) {
            newSelectionStart = oldCalcExpression.selectionStart - 1
            oldCalcExpression.expr.replaceRange(newSelectionStart, oldCalcExpression.selectionEnd, "")
        } else {
            newSelectionStart  = oldCalcExpression.selectionStart
            oldCalcExpression.expr.replaceRange(
                oldCalcExpression.selectionStart,
                oldCalcExpression.selectionEnd,
                ""
            )
        }

        newAnswer = resultOf(newExpr)

        calcExpression.value = CalcExpression(newExpr, newAnswer, newSelectionStart, newSelectionStart)
    }

    fun showResult(expr: String) {
        val result = resultOf(expr)

        if (result.isEmpty() || result == WRONG_EXPRESSION || result == INFINITY) {
            calcExpression.value = CalcExpression(expr, result, expr.length, expr.length)
        } else {
            calcExpression.value = CalcExpression(result, "", result.length, result.length)
        }

    }
}