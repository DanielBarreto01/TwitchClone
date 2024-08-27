package com.example.twitchclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TransmissionAdapter.kt
class TransmissionAdapter(private val transmissions: List<Transmission>) :
    RecyclerView.Adapter<TransmissionAdapter.TransmissionViewHolder>() {

    class TransmissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransmissionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transmission, parent, false)
        return TransmissionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransmissionViewHolder, position: Int) {
        val transmission = transmissions[position]
        holder.imageView.setImageResource(transmission.imageResId)
        holder.textView.text = transmission.title
    }

    override fun getItemCount() = transmissions.size
}