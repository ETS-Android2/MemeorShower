package com.example.memeorshower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.databinding.ActivityMainBinding

class TextTemplate : AppCompatActivity() {
    lateinit var texts: ArrayList<String>
    lateinit var images: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_template)

        val rollButton: Button = findViewById(R.id.NextToImageTemplateButton)
        rollButton.setOnClickListener {
            nextPageToImageTemplate()
        }


        val texts = ArrayList<String>()
        val images = ArrayList<Int>()
        for (i in 1..20) {
            texts.add("Asbbbb"+ i)
            images.add(R.drawable.shower_thought)
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

    private fun nextPageToImageTemplate() {
        val intent = Intent(this, ImageTemplate::class.java)
        startActivity(intent)
    }
}