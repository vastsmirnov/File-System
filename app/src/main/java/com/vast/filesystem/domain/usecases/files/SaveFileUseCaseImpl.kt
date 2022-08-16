package com.vast.filesystem.domain.usecases.files

class SaveFileUseCaseImpl(private val fileRepository: FileRepository):SaveFileUseCase {
    override fun execute(fileData: FileData) {
        this.fileRepository.saveFile(fileData)
    }
}