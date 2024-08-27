package com.example.twitchclone

import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
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
        val titles = listOf(
            "Ninja", "Ibai", "auronplay", "Rubius", "KaiCenat", "xQc", "TheGrefg", "Tfue",
            "juansguarnizo", "Shroud", "ElMariana", "ElSpreen", "Pokimane", "Sodapoppin",
            "Clix", "Heelmike", "Tommyinnit", "Myth", "AdinRoss", "Alanzoka", "SypherPK",
            "TimTheTatman", "AriGameplays", "Mongraal", "Riot Games", "NICKMERCS", "Quackity",
            "ESLCS", "summit1g", "Amouranth", "Dream", "rivers_gg", "Jynxzi", "Fortnite",
            "Robleis", "elded", "loud_coringa", "Bugha", "Moistcr1tikal", "NickEh30",
            "MontanaBlack88", "loltyler1"
        )
        val imageResIds = listOf(
            R.drawable.ninja, R.drawable.ibai, R.drawable.auronplay, R.drawable.rubius,
            R.drawable.kaicenat, R.drawable.xqc, R.drawable.thegrefg, R.drawable.tfue,
            R.drawable.juansguarnizo, R.drawable.shroud, R.drawable.elmariana, R.drawable.elspreen,
            R.drawable.pokimane, R.drawable.sodapoppin, R.drawable.clix, R.drawable.heelmike,
            R.drawable.tommyinnit, R.drawable.myth, R.drawable.adinross, R.drawable.alanzoka,
            R.drawable.sypherpk, R.drawable.timthetatman, R.drawable.arigameplays, R.drawable.mongraal,
            R.drawable.riotgames, R.drawable.nickmercs, R.drawable.quackity, R.drawable.eslcs,
            R.drawable.summit1g, R.drawable.amouranth, R.drawable.dream, R.drawable.rivers_gg,
            R.drawable.jynxzi, R.drawable.fortnite, R.drawable.robleis, R.drawable.elded,
            R.drawable.loud_coringa, R.drawable.bugha, R.drawable.moistcr1tikal, R.drawable.nickeh30,
            R.drawable.montanablack88, R.drawable.loltyler1
        )
        for (i in titles.indices) {
            postList.add(Transmission(imageResIds[i], titles[i]))
        }
    }

    private fun addPostsToLL() {
        postList.forEach { post ->
            val postView = layoutInflater.inflate(R.layout.item_transmission, null)

            val tvUsername: TextView = postView.findViewById(R.id.textView)
            tvUsername.text = post.title

            val imageView: ImageView = postView.findViewById(R.id.imageView)
            imageView.setImageResource(post.imageResId)

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