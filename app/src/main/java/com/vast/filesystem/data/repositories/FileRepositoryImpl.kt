package com.vast.filesystem.data.storages.repositories

import com.vast.filesystem.data.storages.AppFileStorage
import com.vast.filesystem.domain.usecases.files.FileListItem
import com.vast.filesystem.domain.usecases.files.FileData
import com.vast.filesystem.domain.usecases.files.FileRepository
import java.io.IOException

class FileRepositoryImpl(private val appFileStorage: AppFileStorage) : FileRepository {
    override fun getFileList(): List<FileListItem> {
        val files = appFileStorage.getFileList()
        if (files.isEmpty()) {
            return emptyList()
        }

        return files.map {
            FileListItem(it.name)
        }
    }

    override fun saveFile(fileData: FileData) {
        this.appFileStorage.saveNewFile(fileData.name, fileData.content)
    }

    override fun delete(fileListItem: FileListItem) {
        appFileStorage.delete(fileListItem.name)
    }
}