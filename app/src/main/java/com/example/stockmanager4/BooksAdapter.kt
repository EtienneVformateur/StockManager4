package com.example.stockmanager4

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class BooksAdapter(private val mBook: List<Book>) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.TVName)
        val priceTextView = itemView.findViewById<TextView>(R.id.TVPrice)
        val imageUrlView = itemView.findViewById<ImageView>(R.id.IVBook)
    }
    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val bookView = inflater.inflate(R.layout.item_book, parent, false)
        // Return a new holder instance
        return ViewHolder(bookView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: BooksAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val book: Book = mBook.get(position)
        // Set item views based on your views and data model
        val nametextView = viewHolder.nameTextView
        nametextView.text = book.Name
        val pricetextView = viewHolder.priceTextView
        pricetextView.text = book.Price.toString()
        val imageUrlV = viewHolder.imageUrlView
        Picasso.get().load(book.ImageUrl).into(imageUrlV)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mBook.size
    }
}