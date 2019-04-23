package com.example.sneakeryard.logic

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sneakeryard.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class ShoeAdapter(private val shoes: ArrayList<Shoes>) : RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ShoeAdapter.ViewHolder, p1: Int) {
        Picasso.get().load(shoes[p1].photoUrl).into(p0.image)
        p0.title.text = shoes[p1].Title
    }


    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.product_row, p0, false)
        view.setOnClickListener{
            val intent = Intent(p0.context, ShoeDetails::class.java)
            p0.context.startActivity(intent)
        }
        return ViewHolder(view)
    }

    override fun getItemCount() = shoes.size

    class ViewHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder) {

        val image: ImageView = itemView.findViewById(R.id.photo)

        val title : TextView
            get() = itemView.findViewById(R.id.title)

        val price : TextView = itemView.findViewById(R.id.price)

    }

}