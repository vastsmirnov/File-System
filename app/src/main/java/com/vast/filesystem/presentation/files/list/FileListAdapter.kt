package com.vast.filesystem.presentation.files.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vast.filesystem.R
import com.vast.filesystem.databinding.FileListItemBinding
import com.vast.filesystem.domain.usecases.files.FileListItem

class FileListAdapter(private val fileRemoveOnClickListener: FileRemoveOnClickListener): ListAdapter<FileListItem, FileListAdapter.FileListHolder>(diffCallback) {
    companion object {
        private val diffCallback
            get() = object : DiffUtil.ItemCallback<FileListItem>() {
                override fun areItemsTheSame(
                    oldItem: FileListItem,
                    newItem: FileListItem
                ): Boolean = (oldItem.name == newItem.name)

                override fun areContentsTheSame(
                    oldItem: FileListItem,
                    newItem: FileListItem
                ): Boolean = (oldItem == newItem)
            }
    }

    class FileListHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FileListItemBinding.bind(item)

        fun bind(position: Int, file: FileListItem) = with(binding) {
            fileItemNumberTv.text = position.inc().toString()
            fileItemNameTv.text = file.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileListHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.file_list_item, parent, false)

        return FileListHolder(view)
    }

    override fun onBindViewHolder(holder: FileListHolder, position: Int) {
        val file: FileListItem = getItem(position)
        holder.bind(position, file)
        holder.binding.fileItemDeleteMb.setOnClickListener {
            this@FileListAdapter.fileRemoveOnClickListener.onClick(file)
        }
    }

    interface FileRemoveOnClickListener {
        fun onClick(fileListItem: FileListItem)
    }
}