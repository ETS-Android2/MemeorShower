package com.example.memeorshower

import com.example.memeorshower.R
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.memeorshower.database.imagetmp.ImageTmp
import com.example.memeorshower.database.texttmp.TextTmp
import com.example.memeorshower.databinding.ActivityMainBinding
import com.example.memeorshower.viewmodel.ImageTmpViewModel
import com.example.memeorshower.viewmodel.SavedProjectViewModel
import com.example.memeorshower.viewmodel.TextTmpViewModel
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var myImageTmpViewModel: ImageTmpViewModel
    lateinit var myTextTmpViewModel: TextTmpViewModel
    lateinit var mySavedProjectViewModel: SavedProjectViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myImageTmpViewModel = ViewModelProvider(this).get(ImageTmpViewModel::class.java)
        myTextTmpViewModel = ViewModelProvider(this).get(TextTmpViewModel::class.java)
        mySavedProjectViewModel = ViewModelProvider(this).get(SavedProjectViewModel::class.java)

        // todo: you have access to both view models, load your data in them.
        /*
        myTextTmpViewModel.addText(TextTmp(0, "hello"))
        myTextTmpViewModel.addText(TextTmp(1, "bye"))

        myImageTmpViewModel.addImage(ImageTmp(0, imageToBitmap(), "Meme Icon", "This is a meme"))

         */

        binding.NewButton.setOnClickListener { makeNewMeme() }
        binding.MyProjectButton.setOnClickListener { showMyProjects() }
        binding.DatabaseButton.setOnClickListener { showDatabase() }

    }

    private fun showDatabase() {
        val intent = Intent(this, MemeDatabaseActivity::class.java)
        startActivity(intent)
    }

    private fun showMyProjects() {
        val intent = Intent(this, MyProjectsActivity::class.java)
        startActivity(intent)

    }

    private fun makeNewMeme() {
        val intent = Intent(this, TextTemplateActivity::class.java)
        startActivity(intent)
    }

}
