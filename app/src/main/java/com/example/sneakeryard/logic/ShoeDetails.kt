package com.example.sneakeryard.logic

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.example.sneakeryard.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_row.*
import kotlinx.android.synthetic.main.shoe_details.*

class ShoeDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoe_details)

        val title = intent.getStringExtra("title")
        val photoUrl = intent.getStringExtra("photo_url")

        shoe_name.text = title
        Picasso.get().load(photoUrl).into(photo)

      /*  availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Hey, $title is in stock!")
                .setPositiveButton("OK") { p0, p1 ->

                }
                .create()
                .show()
        }*/
    }
}