package com.vast.filesystem.domain.usecases.files

interface SaveFileUseCase {
    fun execute(fileData: FileData)
}