package com.example.testproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.R

class MemeDatabaseAdapter: RecyclerView.Adapter<MemeDatabaseAdapter.ViewHolder>() {
    private var memeImages = intArrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)
    private var memeTitles = arrayOf("Meme1", "Meme2", "Meme3", "Meme4")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeDatabaseAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_database_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemeDatabaseAdapter.ViewHolder, position: Int) {
        holder.memeTitle.text = memeTitles[position]
        holder.memeImage.setImageResource(memeImages[position])
    }

    override fun getItemCount(): Int {
        return memeTitles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var memeImage: ImageView
        var memeTitle: TextView

        init{
            memeImage = itemView.findViewById(R.id.meme_image)
            memeTitle = itemView.findViewById(R.id.meme_title)

            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "Meme saved to favourites", Toast.LENGTH_LONG).show()
            }
        }
    }

}