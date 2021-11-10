package com.example.memeorshower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeorshower.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.NewButton.setOnClickListener { makeNewMeme() }
        binding.MyProjectButton.setOnClickListener { showMyProjects() }
        binding.DatabaseButton.setOnClickListener { showDatabase() }
        


    }

    private fun showDatabase() {
       val  intent = Intent(this, MemeDatabase::class.java)
        startActivity(intent)
    }

    private fun showMyProjects() {
        val  intent = Intent(this, MyProjects::class.java)
        startActivity(intent)

    }

    private fun makeNewMeme() {
        val  intent = Intent(this, TextTemplate::class.java)
        startActivity(intent)
    }
}

