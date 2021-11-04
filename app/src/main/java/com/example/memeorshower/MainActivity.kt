package com.example.memeorshower

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
        TODO("Not yet implemented")
    }

    private fun showMyProjects() {
        TODO("Not yet implemented")
    }

    private fun makeNewMeme() {
        TODO("Not yet implemented")
    }
}