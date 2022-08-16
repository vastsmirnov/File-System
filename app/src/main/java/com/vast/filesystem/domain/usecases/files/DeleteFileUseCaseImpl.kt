package com.vast.filesystem.domain.usecases.files

class DeleteFileUseCaseImpl(private val fileRepository: FileRepository): DeleteFileUseCase {
    override fun execute(fileListItem: FileListItem) {
        fileRepository.delete(fileListItem)
    }
}