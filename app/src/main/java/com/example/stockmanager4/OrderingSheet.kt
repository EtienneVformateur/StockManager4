package com.example.stockmanager4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class OrderingSheet : AppCompatActivity() {
    val listBook = arrayListOf<Book>()
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering_sheet)
        val recyclerBook = findViewById<RecyclerView>(R.id.recycler_book)
        database = Firebase.database("https://stockmanager4-29f0a-default-rtdb.firebaseio.com/").reference
        val BooksReference = database.child("Books")
        BooksReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(Books: DataSnapshot) {
                for (book in Books.children) {
                    val b = Book(book.child("Image").value.toString(),book.child("Name").value.toString(),book.child("Price").value.toString().toInt())
                    listBook.add(b)
                }
                val bAdapter = BooksAdapter(listBook)
                recyclerBook.adapter = bAdapter
                recyclerBook.layoutManager = LinearLayoutManager(applicationContext)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )
//        val b1 = Book("http://www.imagemagick.org/image/gradients/linear_gradient.png","Livre1",10)
//        val b2 = Book ("http://www.imagemagick.org/image/gradients/radial_gradient.png","Livre2",20)
//        val listBook = arrayListOf(b1,b2)



    }
}