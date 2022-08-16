package com.vast.filesystem.domain.usecases.files

class GetFileListUseCaseImpl(private val fileRepository: FileRepository): GetFileListUseCase {
    override fun execute(): List<FileListItem> = fileRepository.getFileList()
}