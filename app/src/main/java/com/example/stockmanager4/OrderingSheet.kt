package com.example.stockmanager4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderingSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering_sheet)
        val recyclerBook = findViewById<RecyclerView>(R.id.recycler_book)


        val b1 = Book("http://www.imagemagick.org/image/gradients/linear_gradient.png","Livre1",10)
        val b2 = Book ("http://www.imagemagick.org/image/gradients/radial_gradient.png","Livre2",20)
        val listBook = arrayListOf(b1,b2)

        val bAdapter = BooksAdapter(listBook)
        recyclerBook.adapter = bAdapter
        recyclerBook.layoutManager = LinearLayoutManager(this)
    }
}