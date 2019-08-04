package com.example.picpaytest.base

import android.app.Application
import com.example.picpaytest.base.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class App: Application(){
    private val modules = listOf(
        baseModules,
        modulesContact,
        modulesPriming,
        modulesRegister,
        modulesPayment
    )
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modules)}
    }
}