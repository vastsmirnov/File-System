package com.vast.filesystem.domain.usecases.files

interface DeleteFileUseCase {
    fun execute(fileListItem: FileListItem)
}