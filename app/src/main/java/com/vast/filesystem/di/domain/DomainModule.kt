package com.vast.filesystem.di.domain

import com.vast.filesystem.domain.usecases.files.*
import org.koin.dsl.module

val domainModule = module {
    single<GetFileListUseCase> {
        GetFileListUseCaseImpl(
            fileRepository = get()
        )
    }

    single<DeleteFileUseCase> {
        DeleteFileUseCaseImpl(
            fileRepository = get()
        )
    }

    single<SaveFileUseCase> {
        SaveFileUseCaseImpl(
            fileRepository = get()
        )
    }
}