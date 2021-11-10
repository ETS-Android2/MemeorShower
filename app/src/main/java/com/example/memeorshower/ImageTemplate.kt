package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ImageTemplate : AppCompatActivity() {
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
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))
        dataList.add(DataModel("Title","Desc",R.drawable.istockphoto_1201221903_170667a))

        photoAdapter.setDataList(dataList)


    }
}