package com.example.twitchclone

import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var llPosts: LinearLayout
    private lateinit var llPostsChannels: GridLayout
    private lateinit var llCategorys: LinearLayout
    private lateinit var BottomNa: BottomNavigationView

    //private lateinit var recyclerView: RecyclerView

    private val postList = arrayListOf<Transmission>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fillPostList()
        addPostsToLL()
        //initrecyclerView()

    }

    private fun fillPostList() {
        val imageResId = R.drawable.special_event
        for (i in 0 until 40) {
            postList.add(Transmission(imageResId,"Username $i"))
        }
    }

    private fun addPostsToLL() {
        postList.forEach { post ->
            val postView = layoutInflater.inflate(R.layout.item_transmission, null)

            val tvUsername: TextView = postView.findViewById(R.id.textView)
            tvUsername.text = post.title

            val params = GridLayout.LayoutParams().apply {
                width = GridLayout.LayoutParams.WRAP_CONTENT
                height = GridLayout.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }
            llPostsChannels.addView(postView, params)
        }
    }

   /* private fun getTransmissions(): List<Transmission> {
        val transmissions = mutableListOf<Transmission>()
        val imageResId = R.drawable.special_event
        for (i in 1..100) { // Adjust the range for the desired number of items
            transmissions.add(Transmission(imageResId, "Title $i"))
        }
        return transmissions
    }
    
    private fun initrecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = TransmissionAdapter(getTransmissions())
    }*/


    private fun initViews() {
        llPosts = findViewById(R.id.linearLayoutHeader)
        llCategorys = findViewById(R.id.linearLayoutFilters)
        BottomNa = findViewById(R.id.bottomNavigationView)
        llPostsChannels = findViewById(R.id.linearLayoutChannels)
    }
    private fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}