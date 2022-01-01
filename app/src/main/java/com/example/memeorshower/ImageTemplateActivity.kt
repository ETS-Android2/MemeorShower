package com.example.memeorshower

import com.example.memeorshower.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.ImageTemplateAdapter
import com.example.memeorshower.model.DataModel
import com.example.memeorshower.viewmodel.ImageTmpViewModel


class ImageTemplateActivity : AppCompatActivity() {
    private lateinit var  photoAdapter: ImageTemplateAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_template)
        val showerThought = intent.getStringExtra("shower_thought_id")
        val image_lists = findViewById<View>(R.id.recyclerView) as RecyclerView
        image_lists.layoutManager = GridLayoutManager(applicationContext,2)
        photoAdapter = ImageTemplateAdapter(applicationContext, showerThought.toString())
        image_lists.adapter = photoAdapter

        // Initialize contacts
        // Create adapter passing in the sample user data
        dataList.add(DataModel("Shower","MemeTemplate",R.drawable.meme1))
        dataList.add(DataModel("Brain","MemeTemplate",R.drawable.meme2))
        dataList.add(DataModel("Grave","MemeTemplate",R.drawable.meme3))
        dataList.add(DataModel("Squidward","MemeTemplate",R.drawable.meme4))
        dataList.add(DataModel("Rick","MemeTemplate",R.drawable.meme5))
        dataList.add(DataModel("Button","MemeTemplate",R.drawable.meme6))
        dataList.add(DataModel("BeautifulMind","MemeTemplate",R.drawable.meme7))
        dataList.add(DataModel("Distract","MemeTemplate",R.drawable.meme8))
        dataList.add(DataModel("Volume","MemeTemplate",R.drawable.meme9))
        dataList.add(DataModel("SpongBob","MemeTemplate",R.drawable.meme10))
        dataList.add(DataModel("WillSmith","MemeTemplate",R.drawable.meme11))
        dataList.add(DataModel("Heart","MemeTemplate",R.drawable.meme12))
        dataList.add(DataModel("SadFace","MemeTemplate",R.drawable.meme13))
        dataList.add(DataModel("Math","MemeTemplate",R.drawable.meme14))
        dataList.add(DataModel("Fall","MemeTemplate",R.drawable.meme10))
        dataList.add(DataModel("Title","MemeTemplate",R.drawable.meme16))

        photoAdapter.setDataList(dataList)

    }
}