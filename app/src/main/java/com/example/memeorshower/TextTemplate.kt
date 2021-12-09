package com.example.memeorshower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.TextTemplateAdapter

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


        val texts = listOf("You need to kill two killers to make the number of killers in the world go down" ,"There is a person that qualifies as the most average person on Earth",
            "Our pets must think that it is odd when we put on new fur every day.","Telling a billionaire they look like a million bucks may be insulting.","It doesn’t seem right that the word palindrome isn’t a palindrome",
        "Most people want a lot of money so they never have to think about money ever again","There isn’t 1 thing that every single person in the world all agree on","a book is step by step instructions of what to imagine",
        "You are the only one who knows all of your secrets.", "You can use social media DMs of dead people as a notepad / free storage.","cheese is a loaf of milk","The strangest thing we could find on another planet is other humans",
        "Someone probably often remembers something stupid you once said.","One day people are going to be shocked they actually allowed smoking in society","It’s unfair that knees get knee caps while elbows don’t","You're the only person who's heard everything you've ever said.",
        "Cleaning is fun only when no one asks you to do it.","Ketchup doesn’t taste like tomatoes.","If we lived in a perfect world, there'd be no need for doors.")
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
        val intent = Intent(this, ImageTemplate::class.java)
        startActivity(intent)
    }
}