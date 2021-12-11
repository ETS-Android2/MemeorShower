package com.example.memeorshower.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.R

class MyProjectAdapter: RecyclerView.Adapter<MyProjectAdapter.ViewHolder>() {
    private var projectImages = intArrayOf(R.drawable.meme_icon, R.drawable.meme_icon, R.drawable.meme_icon, R.drawable.meme_icon)
    private var projectTitles = arrayOf("project1", "project2", "project3", "project4")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_database_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.projectTitle.text = projectTitles[position]
        holder.projectImage.setImageResource(projectImages[position])
    }

    override fun getItemCount(): Int {
        return projectTitles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var projectImage: ImageView
        var projectTitle: TextView

        init{
            projectImage = itemView.findViewById(R.id.meme_image)
            projectTitle = itemView.findViewById(R.id.meme_title)
        }
    }

}