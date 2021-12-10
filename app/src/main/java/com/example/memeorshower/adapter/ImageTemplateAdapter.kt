package com.example.memeorshower.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.R
import com.example.memeorshower.editor.EditImageActivity
import com.example.memeorshower.model.DataModel


class ImageTemplateAdapter (var context: Context , var showerThought:String):
    RecyclerView.Adapter<ImageTemplateAdapter.ViewHolder>(){
    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var title: TextView
        var desc: TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.text)
        }


    }
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).inflate(R.layout.meme_list_item, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var data = dataList[position]
        // Set item views based on your views and data model
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.image.setImageResource(data.image)
        holder.image.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, EditImageActivity::class.java)
            intent.putExtra("photoId", data.image)
            intent.putExtra("shower_thought_id", showerThought)
            context.startActivity(intent)

        }
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}

