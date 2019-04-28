package com.example.sneakeryard.screens

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sneakeryard.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class StoreFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mGooglemap: GoogleMap
    private lateinit var mMapView: MapView
    private  lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_store, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMapView = mView.findViewById<View>(R.id.map) as MapView
        if (mMapView != null) {
            mMapView!!.onCreate(null)
            mMapView!!.onResume()
            mMapView!!.getMapAsync(this)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        MapsInitializer.initialize(context!!)

        mGooglemap = googleMap
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        googleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    59.911491,
                    10.757933
                )
            ).title("Oslo").snippet("Sneakershops in Oslo")
        )
        val Oslo = CameraPosition.builder().target(LatLng(59.911491, 10.757933)).zoom(16f).bearing(0f).tilt(45f).build()
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Oslo))


    }

}
