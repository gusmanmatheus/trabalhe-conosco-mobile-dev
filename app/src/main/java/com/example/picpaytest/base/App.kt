package com.example.picpaytest.base

import android.app.Application
import com.example.picpaytest.base.modules.moduleContact
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class App: Application(){
    private val modules = listOf(
        moduleContact


    )
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modules)}
    }
}