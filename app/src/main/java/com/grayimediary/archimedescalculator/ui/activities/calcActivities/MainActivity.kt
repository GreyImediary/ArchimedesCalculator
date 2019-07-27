package com.grayimediary.archimedescalculator.ui.activities.calcActivities

import android.os.Bundle
import androidx.lifecycle.Observer
import com.grayimediary.archimedescalculator.R
import kotlinx.android.synthetic.main.activity_calc_base.*
import kotlinx.android.synthetic.main.activty_main.*

class MainActivity : BaseCalcActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activty_main)

        setButtonPanel(mainButtonPanel)

        calcViewModel.calcExpression.observe(this, Observer {
            exprEditText.setText(it.expr)
            exprEditText.setSelection(it.selectionStart, it.selectionEnd)
            answerEditText.setText(it.answer)
        })
    }
}
