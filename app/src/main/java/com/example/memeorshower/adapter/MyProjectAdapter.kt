package com.example.memeorshower.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.R
import com.example.memeorshower.database.savedproject.SavedProject
import com.example.memeorshower.editor.EditImageActivity
import java.io.ByteArrayOutputStream


class MyProjectAdapter(savedProjects: List<SavedProject>): RecyclerView.Adapter<MyProjectAdapter.ViewHolder>() {
    private var projectsImage = mutableListOf<Bitmap>()
    private var projectsDate = mutableListOf<String>()

    init {
        for (project in savedProjects){
            val bmp = BitmapFactory.decodeByteArray(project.data, 0, project.data!!.size)
            projectsImage.add(bmp)
            projectsDate.add(project.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meme_database_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.projectTitle.text = projectsDate[position]
        holder.projectImage.setImageBitmap(projectsImage[position])
    }

    override fun getItemCount(): Int {
        return projectsImage.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var projectImage: ImageView
        var projectTitle: TextView

        init{
            projectImage = itemView.findViewById(R.id.meme_image)
            projectTitle = itemView.findViewById(R.id.meme_title)

            projectImage.setOnClickListener{
                val position: Int = adapterPosition
                openPage(position)
            }
        }

        private fun openPage(position: Int){
            val context = itemView.context
            val intent = Intent(context, EditImageActivity::class.java)
            val stream = ByteArrayOutputStream()
            projectsImage[position].compress(Bitmap.CompressFormat.PNG, 90, stream)
            val image = stream.toByteArray()
            intent.putExtra("imageByteArray", image)
            intent.putExtra("shower_thought_id", "null")
            context.startActivity(intent)
        }
    }


}