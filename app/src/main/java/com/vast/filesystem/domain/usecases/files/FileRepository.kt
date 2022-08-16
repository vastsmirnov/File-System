package com.vast.filesystem.domain.usecases.files

interface FileRepository {
    fun getFileList(): List<FileListItem>

    fun saveFile(fileData: FileData)

    fun delete(fileListItem: FileListItem)
}