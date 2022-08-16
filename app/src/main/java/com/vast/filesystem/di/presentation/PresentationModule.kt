package com.vast.filesystem.di

import com.vast.filesystem.presentation.files.list.FileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        FileViewModel(
            getFileListUseCase = get(),
            deleteFileUseCase = get(),
            saveFileUseCase = get()
        )
    }
}