package com.vast.filesystem

import android.app.Application
import com.vast.filesystem.di.data.dataModule
import com.vast.filesystem.di.domain.domainModule
import com.vast.filesystem.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}