package com.vast.filesystem.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vast.filesystem.R
import com.vast.filesystem.presentation.files.list.FileListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, FileListFragment.newInstance())
            .commit()
    }
}