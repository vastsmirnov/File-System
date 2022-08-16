package com.vast.filesystem.di.data

import com.vast.filesystem.data.storages.AppFileStorage
import com.vast.filesystem.domain.usecases.files.FileRepository
import com.vast.filesystem.data.storages.repositories.FileRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single <FileRepository> {
        FileRepositoryImpl(
            appFileStorage = get()
        )
    }

    single {
        AppFileStorage(
            filesDir = androidContext().filesDir
        )
    }
}