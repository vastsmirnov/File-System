package com.vast.filesystem.data.storages

import java.io.*

class AppFileStorage(private val filesDir: File) {

    init {
        if (!filesDir.exists()) {
            throw IOException("Files directory must be exist")
        }
    }

    fun getFileList(): Array<out File> {
        return filesDir.listFiles() ?: return emptyArray()
    }

    fun saveNewFile(name: String, content: String) {
        this.createFile(name).writeText(content)
    }

    fun delete(name: String) {
        val file = File(this.filesDir, name)

        if (!file.exists()) {
            throw IOException("File not found")
        }

        file.delete()
    }

    private fun createFile(name: String, index: Int = 0): File {
        var fileName = name

        if(index > 0) {
            fileName += "_$index"
        }

        val newFile = File(this.filesDir, fileName)
        if (!newFile.exists()) {
            return newFile
        }

        return this.createFile(name, index.inc())
    }
}