package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.MemeDatabaseAdapter
import com.example.memeorshower.adapter.MyProjectAdapter
import com.example.memeorshower.database.savedproject.SavedProject
import com.example.memeorshower.viewmodel.SavedProjectViewModel

class MyProjectsActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?= null
    private lateinit var adapter: MyProjectAdapter
    lateinit var mySavedProjectViewModel: SavedProjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_projects)
        mySavedProjectViewModel = ViewModelProvider(this).get(SavedProjectViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        val recyclerView= findViewById<View>(R.id.my_projects_recycler_view) as RecyclerView
        adapter = MyProjectAdapter(mySavedProjectViewModel.getProjects())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}