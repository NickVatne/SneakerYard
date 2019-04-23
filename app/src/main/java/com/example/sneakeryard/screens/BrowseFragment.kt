package com.example.sneakeryard.screens


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sneakeryard.R
import com.example.sneakeryard.logic.ShoeAdapter
import com.example.sneakeryard.logic.Shoes
import kotlinx.android.synthetic.main.fragment_browse.*
import android.support.v7.widget.RecyclerView
import android.widget.Button




class BrowseFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_browse, null)
        val button = view.findViewById(R.id.photoButton) as Button

        button.setOnClickListener {
            // TODO
          //  CameraActivity()
            val intent = Intent(view.context, CameraActivity::class.java)
            startActivity(intent)

        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Shoes = arrayListOf<Shoes>()
        for (i in 0..4) {
            Shoes.add(
                Shoes(
                    "Yeezy 350 True Form",
                    "https://sneakernews.com/wp-content/uploads/2019/03/adidas-yeezy-boost-350-v2-trfrm-1.jpg",
                    450.22
                )
            )
            Shoes.add(
                Shoes(
                    "Jordan 1 Phantom Retro",
                    "https://sneakernews.com/wp-content/uploads/2019/01/air-jordan-1-phantom-555088-160-2.jpg",
                    300.00
                )
            )
            Shoes.add(
                Shoes(
                    " OFF-WHITE x Nike Blazers Grim Reaper ",
                    "https://sneakernews.com/wp-content/uploads/2018/09/off-white-nike-blazer-aa3832-001-black-1.jpg",
                    700.00
                )
            )
            Shoes.add(
                Shoes(
                    "OFF-WHITE x Nike Blazers All Hallows Eve",
                    "https://sneakernews.com/wp-content/uploads/2018/09/off-white-nike-blazer-tan-orange-aa3832-700-release-info-5.jpg",
                    700.00
                )
            )
            Shoes.add(
                Shoes(
                    "Off-White x Converse Chuck 70",
                    "https://sneakernews.com/wp-content/uploads/2018/09/off-white-converse-chuck-70-photos-1.jpg",
                    300.00
                )
            )

        }
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
            adapter = ShoeAdapter(Shoes)
        }
    }

    companion object {
        fun newInstance(): BrowseFragment = BrowseFragment()
    }
}



