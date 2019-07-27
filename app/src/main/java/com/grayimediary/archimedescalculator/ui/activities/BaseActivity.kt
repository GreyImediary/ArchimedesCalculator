package com.grayimediary.archimedescalculator.ui.activities

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.grayimediary.archimedescalculator.R
import com.grayimediary.archimedescalculator.common.constants.PREFS_NAME
import kotlinx.android.synthetic.main.activity_base.view.*

abstract class BaseActivity : AppCompatActivity() {
    val prefs: SharedPreferences by lazy {
        getSharedPreferences(PREFS_NAME, 0)
    }

    override fun setContentView(layoutResID: Int) {

        val baseActivityLayout = layoutInflater.inflate(R.layout.activity_base, null)
                as ConstraintLayout

        baseActivityLayout.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.actionSettings -> {}
                R.id.actionHistory -> {}
            }

            true
        }

        baseActivityLayout.baseActivityContent.run {
            layoutResource = layoutResID
            inflate()
        }
        super.setContentView(baseActivityLayout)
    }
}