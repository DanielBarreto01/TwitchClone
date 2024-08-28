package com.example.twitchclone.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitchclone.R
import com.example.twitchclone.data.Transmission
import com.example.twitchclone.utils.showToast

class RVAdapterPosts(private val posts: List<Transmission>) :
    RecyclerView.Adapter<RVAdapterPosts.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val imageButtonChannel: ImageButton = view.findViewById(R.id.imageButtonChannel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transmission, parent, false)
        return PostViewHolder(postView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvUserName.text = posts[position].title
        holder.imageView.setImageResource(posts[position].imageResId)
        holder.imageButtonChannel.setOnClickListener {
            it.context.showToast("Channel button clicked for ${posts[position].title}")
        }
    }

    override fun getItemCount(): Int = posts.size

}