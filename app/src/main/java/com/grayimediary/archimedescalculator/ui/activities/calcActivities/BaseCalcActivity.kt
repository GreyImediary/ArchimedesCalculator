package com.grayimediary.archimedescalculator.ui.activities.calcActivities

import com.grayimediary.archimedescalculator.models.CalcExpression
import com.grayimediary.archimedescalculator.ui.activities.BaseActivity
import com.grayimediary.archimedescalculator.ui.views.OnCalcButtonsClickListener
import com.grayimediary.archimedescalculator.viemodels.CalcViewModel
import com.grayimediary.archimedescalculator.R
import kotlinx.android.synthetic.main.activity_calc_base.*
import org.koin.android.viewmodel.ext.android.viewModel

abstract class BaseCalcActivity : BaseActivity() {

    val calcViewModel: CalcViewModel by viewModel()

    override fun setContentView(layoutResID: Int) {

        super.setContentView(R.layout.activity_calc_base)

        answerEditText.apply {
            showSoftInputOnFocus = false
        }
        exprEditText.apply {
            showSoftInputOnFocus = false
        }

        calcPanelContainer.run {
            layoutResource = layoutResID
            inflate()
        }
    }

    protected fun setButtonPanel(buttonPanel: OnCalcButtonsClickListener) {
        buttonPanel.setOnDefaultButtonsClick {
            val expression = CalcExpression(
                exprEditText.text.toString(),
                answerEditText.text.toString(),
                exprEditText.selectionStart,
                exprEditText.selectionEnd
            )
            calcViewModel.addSymbol(expression, it)
        }

        buttonPanel.setOnClearButtonClick {
            calcViewModel.clearExpression()
        }

        buttonPanel.setOnRemoveButtonClick {
            val expression = CalcExpression(
                exprEditText.text.toString(),
                answerEditText.text.toString(),
                exprEditText.selectionStart,
                exprEditText.selectionEnd
            )
            calcViewModel.removeSymbol(expression)
        }

        buttonPanel.setOnEqualityButtonClick {
            calcViewModel.showResult(exprEditText.text.toString())
        }
    }
}