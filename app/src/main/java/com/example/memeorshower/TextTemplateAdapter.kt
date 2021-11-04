package com.example.memeorshower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextTemplateAdapter (private var titles: List<String>, private var images: List<Int>):
RecyclerView.Adapter<TextTemplateAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.textView1)
        val itemImage: ImageView = itemView.findViewById(R.id.imageView1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemImage.setImageResource(images[position])
//        holder.itemDetail.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}