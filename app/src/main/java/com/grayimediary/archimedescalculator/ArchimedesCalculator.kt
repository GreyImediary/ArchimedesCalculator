package com.grayimediary.archimedescalculator

import android.app.Application
import com.grayimediary.archimedescalculator.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ArchimedesCalculator : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ArchimedesCalculator)
            androidFileProperties()
            modules(listOf(vmModule))
        }
    }
}