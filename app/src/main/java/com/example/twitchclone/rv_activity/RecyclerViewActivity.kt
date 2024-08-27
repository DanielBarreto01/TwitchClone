package com.example.twitchclone.rv_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchclone.R
import com.example.twitchclone.data.Transmission

class RecyclerViewActivity: AppCompatActivity() {


private lateinit var rvPosts: RecyclerView
private val postList = arrayListOf<Transmission>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()

    }

    private fun initializeView() {
        rvPosts = findViewById(R.id.rv_posts)
    }
}