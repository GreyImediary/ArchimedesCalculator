package com.grayimediary.archimedescalculator.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.grayimediary.archimedescalculator.R
import com.grayimediary.archimedescalculator.common.OnDefaultButtonClick
import com.grayimediary.archimedescalculator.common.OnSpecialButtonClick
import kotlinx.android.synthetic.main.view_calc_button_panel.view.*

class CalcButtonPanel : ConstraintLayout, OnCalcButtonsClickListener {

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.view_calc_button_panel, this, true)

    }

    override fun setOnClearButtonClick(onClearButtonClick: OnSpecialButtonClick) {
        clearButton.setOnClickListener {
            onClearButtonClick()
        }
    }

    override fun setOnRemoveButtonClick(onRemoveButtonClick: OnSpecialButtonClick) {
        removeButton.setOnClickListener {
            onRemoveButtonClick()
        }
    }

    override fun setOnEqualityButtonClick(onEqualityButtonClick: OnSpecialButtonClick) {
        equalityButton.setOnClickListener {
            onEqualityButtonClick()
        }
    }

    override fun setOnDefaultButtonsClick(onDefaultButtonClick: OnDefaultButtonClick) {
        leftBracketButton.setOnClickListener {
            onDefaultButtonClick(leftBracketButton.text.toString())
        }

        rightBracketButton.setOnClickListener {
            onDefaultButtonClick(rightBracketButton.text.toString())
        }

        nineButton.setOnClickListener {
            onDefaultButtonClick(nineButton.text.toString())
        }

        eightButton.setOnClickListener {
            onDefaultButtonClick(eightButton.text.toString())
        }

        sevenButton.setOnClickListener {
            onDefaultButtonClick(sevenButton.text.toString())
        }

        sixButton.setOnClickListener {
            onDefaultButtonClick(sixButton.text.toString())
        }

        fiveButton.setOnClickListener {
            onDefaultButtonClick(fiveButton.text.toString())
        }

        fourButton.setOnClickListener {
            onDefaultButtonClick(fourButton.text.toString())
        }

        threeButton.setOnClickListener {
            onDefaultButtonClick(threeButton.text.toString())
        }

        twoButton.setOnClickListener {
            onDefaultButtonClick(twoButton.text.toString())
        }

        oneButton.setOnClickListener {
            onDefaultButtonClick(oneButton.text.toString())
        }

        zeroButton.setOnClickListener {
            onDefaultButtonClick(zeroButton.text.toString())
        }

        dotButton.setOnClickListener {
            onDefaultButtonClick(dotButton.text.toString())
        }

        divisionButton.setOnClickListener {
            onDefaultButtonClick(divisionButton.text.toString())
        }

        multiplicationButton.setOnClickListener {
            onDefaultButtonClick(multiplicationButton.text.toString())
        }

        subtractionButton.setOnClickListener {
            onDefaultButtonClick(subtractionButton.text.toString())
        }

        sumButton.setOnClickListener {
            onDefaultButtonClick(sumButton.text.toString())
        }
    }
}