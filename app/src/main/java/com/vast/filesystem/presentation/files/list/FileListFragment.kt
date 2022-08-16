package com.vast.filesystem.presentation.files.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vast.filesystem.databinding.FragmentFileListBinding
import com.vast.filesystem.domain.usecases.files.FileData
import com.vast.filesystem.domain.usecases.files.FileListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class FileListFragment : Fragment() {
    private val fileViewModel by viewModel<FileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFileListBinding.inflate(
            inflater,
            container,
            false
        )

        val fileListAdapter = FileListAdapter(object : FileListAdapter.FileRemoveOnClickListener {
            override fun onClick(fileListItem: FileListItem) {
                fileViewModel.remove(fileListItem)
            }
        })

        fileViewModel.fileListLiveData.observe(viewLifecycleOwner) {
            if(it.isNotEmpty()) {
                binding.fileListEmptyMessageTv.visibility = View.GONE
            } else {
                binding.fileListEmptyMessageTv.visibility = View.VISIBLE
            }

            fileListAdapter.submitList(it)
        }

        binding.apply {
            clearFieldMb.setOnClickListener {
                fileNameEt.text = null
                fileContentEt.text = null
            }

            fileListRv.layoutManager = LinearLayoutManager(this@FileListFragment.context)
            fileListRv.adapter = fileListAdapter

            saveFileMb.setOnClickListener {
                val name = fileNameEt.text.toString()
                val content = fileContentEt.text.toString()
                fileViewModel.create(FileData(
                    name = name,
                    content = content
                ))

                fileNameEt.text = null
                fileContentEt.text = null
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FileListFragment()
    }
}