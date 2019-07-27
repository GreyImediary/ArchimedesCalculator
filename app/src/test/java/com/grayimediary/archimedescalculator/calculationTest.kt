package com.grayimediary.archimedescalculator


import com.grayimediary.archimedescalculator.algorithms.resultOf
import com.grayimediary.archimedescalculator.common.constants.DIVISION
import com.grayimediary.archimedescalculator.common.constants.INFINITY
import com.grayimediary.archimedescalculator.common.constants.MULTIPLICATION
import com.grayimediary.archimedescalculator.common.constants.WRONG_EXPRESSION
import org.spekframework.spek2.Spek
import kotlin.test.assertEquals

object Tests : Spek({
    group("calc test") {
        test("2-1") {
            assertEquals(actual = resultOf("2-1"), expected = "1")
        }

        test("2--1") {
            assertEquals(actual = resultOf("2--1"), expected = "3")
        }

        test("1.01+1.02") {
            assertEquals(actual = resultOf("1.01+1.02"), expected = "2.03")
        }

        test("10000000000000*2/2+6") {
            assertEquals(
                actual = resultOf("10000000000000${MULTIPLICATION}2${DIVISION}2+6"),
                expected = "1.0000000000006E13"
            )
        }

        test("2*.33") {
            assertEquals(actual = resultOf("2$MULTIPLICATION.33"), expected = "0.66")
        }

        test("2-.1") {
            assertEquals(actual = resultOf("2-.1"), expected = "1.9")
        }

        test(".1+.9") {
            assertEquals(actual = resultOf(".1+.9"), expected = "1")
        }

        test("2.3666-1.437") {
            assertEquals(actual = resultOf("2.36-1.437"), expected = "0.923")
        }

        test("2-(-3)") {
            assertEquals(actual = resultOf("2-(-3)"), expected = "5")
        }

        test("-3-2") {
            assertEquals(actual = resultOf("-3-2"), expected = "-5")
        }

        test("2*-3") {
            assertEquals(actual = resultOf("2$MULTIPLICATION-3"), expected = "-6")
        }

        test("2+-3") {
            assertEquals(actual = resultOf("2+-3"), expected = "-1")
        }

        test("2123--3000") {
            assertEquals(actual = resultOf("2123--3000"), expected = "5123")
        }

        test("1/3") {
            assertEquals(actual = resultOf("1${DIVISION}3"), expected = "0.3333333333333333")
        }

        test("2*1.24") {
            assertEquals(actual = resultOf("2${MULTIPLICATION}1.24"), expected = "2.48")
        }

        test("2.3*1.45") {
            assertEquals(actual = resultOf("2.3${MULTIPLICATION}1.45"), expected = "3.335")
        }

        test("3/0") {
            assertEquals(actual = resultOf("3${DIVISION}0"), expected = INFINITY)
        }

        test("3/") {
            assertEquals(
                actual = resultOf("3$DIVISION"),
                expected = WRONG_EXPRESSION
            )
        }

        test("3*6/(9*8)") {
            assertEquals(
                actual = resultOf(
                    "3${MULTIPLICATION}6$DIVISION(9${MULTIPLICATION}8)"
                ),
                expected = "0.25"
            )
        }

        test("1/100") {
            assertEquals(actual = resultOf("1${DIVISION}100.0"), expected = "0.01")
        }

        test("6/72") {
            assertEquals(actual = resultOf("6${DIVISION}72"), expected = "0.0833333333333333")
        }

        test("Brackets MULTIPLICATION") {
            assertEquals(actual = resultOf("(6)(6)"), expected = "36")
        }

        test("Calculation with one left bracket") {
            assertEquals(actual = resultOf("5+(11"), expected = WRONG_EXPRESSION)
        }

        test("Calculation with one right bracket") {
            assertEquals(actual = resultOf("5+11)"), expected = WRONG_EXPRESSION)
        }

        test("order") {
            assertEquals(
                actual = resultOf(
                    "2-1${MULTIPLICATION}2$DIVISION(4+1)"
                ),
                expected = "1.6"
            )
        }
    }
})