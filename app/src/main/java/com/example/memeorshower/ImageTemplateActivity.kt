package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.ImageTemplateAdapter
import com.example.memeorshower.model.DataModel


class ImageTemplateActivity : AppCompatActivity() {
    private lateinit var  photoAdapter: ImageTemplateAdapter
    private var dataList = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_template)
        val image_lists = findViewById<View>(R.id.recyclerView) as RecyclerView
        image_lists.layoutManager = GridLayoutManager(applicationContext,2)
        photoAdapter = ImageTemplateAdapter(applicationContext)
        image_lists.adapter = photoAdapter


        // Initialize contacts
        // Create adapter passing in the sample user data
        dataList.add(DataModel("Title","Desc",R.drawable.meme_icon))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme2))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme3))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme4))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme5))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme6))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme7))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme8))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme9))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme10))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme11))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme12))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme13))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme14))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme15))
//        dataList.add(DataModel("Title","Desc",R.drawable.meme16))

        photoAdapter.setDataList(dataList)


    }
}