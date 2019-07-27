package com.grayimediary.archimedescalculator.di

import com.grayimediary.archimedescalculator.viemodels.CalcViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { CalcViewModel() }
}