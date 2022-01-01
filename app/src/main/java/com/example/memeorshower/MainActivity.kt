package com.example.memeorshower

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.memeorshower.database.imagetmp.ImageTmp
import com.example.memeorshower.database.texttmp.TextTmp
import com.example.memeorshower.databinding.ActivityMainBinding
import com.example.memeorshower.model.DataModel
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

//        myImageTmpViewModel = ViewModelProvider(this).get(ImageTmpViewModel::class.java)
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

        loadTextTmp()
        //loadImageTmp()

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

    private fun loadTextTmp(){
        if (myTextTmpViewModel.getAll().isEmpty()){
            val texts = listOf("You need to kill two killers to make the number of killers in the world go down" ,"There is a person that qualifies as the most average person on Earth",
                "Our pets must think that it is odd when we put on new fur every day.","Telling a billionaire they look like a million bucks may be insulting.","It doesn’t seem right that the word palindrome isn’t a palindrome",
                "Most people want a lot of money so they never have to think about money ever again","There isn’t 1 thing that every single person in the world all agree on","a book is step by step instructions of what to imagine",
                "You are the only one who knows all of your secrets.", "You can use social media DMs of dead people as a notepad / free storage.","cheese is a loaf of milk","The strangest thing we could find on another planet is other humans",
                "Someone probably often remembers something stupid you once said.","One day people are going to be shocked they actually allowed smoking in society","It’s unfair that knees get knee caps while elbows don’t","You're the only person who's heard everything you've ever said.",
                "Cleaning is fun only when no one asks you to do it.","Ketchup doesn’t taste like tomatoes.","If we lived in a perfect world, there'd be no need for doors.")

            for(text in texts)
                myTextTmpViewModel.addText(TextTmp(0, text))
        }
    }

    private fun loadImageTmp(){

        if(myImageTmpViewModel.getAll().isEmpty()){

            addImage(R.drawable.meme1, "Shower", "MemeTemplate")
            addImage(R.drawable.meme2, "Brain","MemeTemplate")
            addImage(R.drawable.meme3, "Grave", "MemeTemplate")
            addImage(R.drawable.meme4, "Squidward", "MemeTemplate")
            addImage(R.drawable.meme5, "Rick", "MemeTemplate")
            addImage(R.drawable.meme6, "Button", "MemeTemplate")
            addImage(R.drawable.meme7, "BeautifulMind", "MemeTemplate")
            addImage(R.drawable.meme8, "Distract", "MemeTemplate")
            addImage(R.drawable.meme9, "Volume", "MemeTemplate")
            addImage(R.drawable.meme10, "SpongBob", "MemeTemplate")
            addImage(R.drawable.meme11, "WillSmith", "MemeTemplate")
            addImage(R.drawable.meme12, "Heart", "MemeTemplate")
            addImage(R.drawable.meme13, "SadFace", "MemeTemplate")
            addImage(R.drawable.meme14, "Math", "MemeTemplate")
            addImage(R.drawable.meme16, "Title", "MemeTemplate")
        }

    }

    private fun addImage(id: Int, title: String, desc: String){
        val stream = ByteArrayOutputStream()

        val icon = BitmapFactory.decodeResource(resources, id)
        icon.compress(Bitmap.CompressFormat.PNG, 90, stream)
        val image = stream.toByteArray()
        myImageTmpViewModel.addImage(ImageTmp(0, image, title, desc))
    }


}
