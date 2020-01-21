package com.structure

import android.app.Application
import com.structure.di.appModule
import com.structure.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

public class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(appModule, viewModelModule))
        }
    }

}