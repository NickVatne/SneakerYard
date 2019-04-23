package com.example.sneakeryard

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem
import com.example.sneakeryard.screens.BrowseFragment
import com.example.sneakeryard.screens.HomeFragment
import com.example.sneakeryard.screens.MyProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.navigation_home -> fragment = HomeFragment()

            R.id.navigation_dashboard-> fragment = BrowseFragment()

            R.id.navigation_notifications -> fragment = MyProfileFragment()

        }

        return loadFragment(fragment)
    }
    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
