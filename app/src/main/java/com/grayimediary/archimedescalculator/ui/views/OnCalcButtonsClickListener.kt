package com.grayimediary.archimedescalculator.ui.views

import com.grayimediary.archimedescalculator.common.OnDefaultButtonClick
import com.grayimediary.archimedescalculator.common.OnSpecialButtonClick

interface OnCalcButtonsClickListener {
    fun setOnClearButtonClick(onClearButtonClick: OnSpecialButtonClick)
    fun setOnRemoveButtonClick(onRemoveButtonClick: OnSpecialButtonClick)
    fun setOnEqualityButtonClick(onEqualityButtonClick: OnSpecialButtonClick)
    fun setOnDefaultButtonsClick(onDefaultButtonClick: OnDefaultButtonClick)
}