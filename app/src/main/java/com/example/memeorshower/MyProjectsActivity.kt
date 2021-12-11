package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.MemeDatabaseAdapter
import com.example.memeorshower.adapter.MyProjectAdapter

class MyProjectsActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?= null
    private lateinit var adapter: MyProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_projects)

        layoutManager = LinearLayoutManager(this)
        val recyclerView= findViewById<View>(R.id.my_projects_recycler_view) as RecyclerView
        adapter = MyProjectAdapter()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}