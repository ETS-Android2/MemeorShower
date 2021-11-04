package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TextTemplate : AppCompatActivity() {
    lateinit var texts: ArrayList<String>
    lateinit var images: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_template)

        val texts = ArrayList<String>()
        val images = ArrayList<Int>()
        for (i in 1..20) {
            texts.add("Asbbbb"+ i)
            images.add(R.mipmap.ic_launcher)
        }

        val text_lists = findViewById<View>(R.id.text_list) as RecyclerView
        // Initialize contacts
        // Create adapter passing in the sample user data
        val adapter = TextTemplateAdapter(texts, images)
        // Attach the adapter to the recyclerview to populate items
        text_lists.adapter = adapter
        // Set layout manager to position the items
        text_lists.layoutManager = LinearLayoutManager(this)

    }
}