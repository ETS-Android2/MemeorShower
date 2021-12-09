package com.example.memeorshower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memeorshower.adapter.MemeDatabaseAdapter

class MemeDatabase : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?= null
    private lateinit var adapter: MemeDatabaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme_database)

        layoutManager = LinearLayoutManager(this)
        val recyclerView= findViewById<View>(R.id.meme_database_recycler_view) as RecyclerView
        adapter = MemeDatabaseAdapter()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}