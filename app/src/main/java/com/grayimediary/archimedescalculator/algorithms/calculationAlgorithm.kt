package com.grayimediary.archimedescalculator.algorithms

import com.grayimediary.archimedescalculator.common.constants.DIVISION
import com.grayimediary.archimedescalculator.common.constants.INFINITY
import com.grayimediary.archimedescalculator.common.constants.MULTIPLICATION
import com.grayimediary.archimedescalculator.common.constants.WRONG_EXPRESSION
import org.mariuszgromada.math.mxparser.Expression

fun resultOf(expr: String): String {
    val parsedExpr = parseString(expr)

    val expression = Expression(parsedExpr)

    if (expression.checkSyntax()) {
        val result = expression.calculate()

        if (result.isNaN()) {
            return INFINITY
        }

        return roundIfZeroFraction(result)
    }

    return WRONG_EXPRESSION
}

private fun parseString(expr: String): String {
    var parsingExpr = expr
        .replace(")(", ")*(")
        .replace("+-", "-")
        .replace("--", "+")
        .replace(MULTIPLICATION, "*")
        .replace(DIVISION, "/")

    return parsingExpr
}

private fun roundIfZeroFraction(number: Double) =
    if (number % 1.0 == 0.0
        && !number.toString().contains('E')
    ) number.toInt().toString()
    else number.toString()