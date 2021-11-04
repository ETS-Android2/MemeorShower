package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageTemplate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_template)

        val images = ArrayList<Int>()
        for (i in 1..20) {
            images.add(R.mipmap.ic_launcher)
        }

        val image_lists = findViewById<View>(R.id.image_list) as RecyclerView
        // Initialize contacts
        // Create adapter passing in the sample user data
        val adapter = ImageTemplateAdapter(images)
        // Attach the adapter to the recyclerview to populate items
        image_lists.adapter = adapter
        // Set layout manager to position the items
        //todo what's this shit spancount
        image_lists.layoutManager = GridLayoutManager(this, 20)


    }
}