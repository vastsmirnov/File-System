package com.vast.filesystem.domain.usecases.files

interface GetFileListUseCase {
    fun execute(): List<FileListItem>
}