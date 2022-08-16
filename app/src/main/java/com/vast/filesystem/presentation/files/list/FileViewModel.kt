package com.vast.filesystem.presentation.files.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vast.filesystem.domain.usecases.files.*

class FileViewModel(
    private val getFileListUseCase: GetFileListUseCase,
    private val deleteFileUseCase: DeleteFileUseCase,
    private val saveFileUseCase: SaveFileUseCase
) : ViewModel() {
    private val _fileListLiveData = MutableLiveData<List<FileListItem>>()
    val fileListLiveData = _fileListLiveData as LiveData<List<FileListItem>>

    init {
        loadData()
    }

    fun remove(fileListItem: FileListItem) {
        deleteFileUseCase.execute(fileListItem)
        loadData()
    }

    fun create(fileData: FileData) {
        saveFileUseCase.execute(fileData)
        loadData()
    }

    private fun loadData() {
        this._fileListLiveData.value = getFileListUseCase.execute()
    }
}