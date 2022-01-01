package com.example.memeorshower

import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.TextTemplateAdapter
import com.example.memeorshower.viewmodel.TextTmpViewModel

class TextTemplateActivity : AppCompatActivity() {
    lateinit var texts: ArrayList<String>
    lateinit var images: ArrayList<Int>
    lateinit var myTextTmpViewModel: TextTmpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_template)

        val rollButton: Button = findViewById(R.id.NextToImageTemplateButton)
        rollButton.setOnClickListener {
            nextPageToImageTemplate()
        }
        texts = ArrayList()
        myTextTmpViewModel = ViewModelProvider(this).get(TextTmpViewModel::class.java)
        val showerThoughts = myTextTmpViewModel.getAll()

        for (showerThought in showerThoughts){
            texts.add(showerThought.text)
        }

        val images = ArrayList<Int>()
        for (i in 0..texts.size) {
            images.add(R.drawable.shower_thought)
//            texts.add("Asbbbb"+ i)
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
        val intent = Intent(this, ImageTemplateActivity::class.java)
        startActivity(intent)
    }

}