package com.example.memeorshower.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.R
import com.example.memeorshower.database.savedproject.SavedProject


class MyProjectAdapter(savedProjects: List<SavedProject>): RecyclerView.Adapter<MyProjectAdapter.ViewHolder>() {
    private var projectImage = mutableListOf<Bitmap>()
    private var projectDate = mutableListOf<String>()

    init {
        for (project in savedProjects){
            val bmp = BitmapFactory.decodeByteArray(project.data, 0, project.data!!.size)
            projectImage.add(bmp)
            projectDate.add(project.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_database_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.projectTitle.text = projectDate[position]
        holder.projectImage.setImageBitmap(projectImage[position])
    }

    override fun getItemCount(): Int {
        return projectImage.size
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