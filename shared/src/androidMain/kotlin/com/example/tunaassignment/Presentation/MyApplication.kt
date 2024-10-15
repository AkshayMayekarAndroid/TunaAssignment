package com.example.tunaassignment.Presentation

import android.app.Application
import com.example.tunaassignment.di.sharedModule
import com.example.tunaassignment.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            // Pass Android context to Koin
            androidContext(this@MyApplication)
            modules(sharedModule,androidModule)
        }
    }
}