package com.example.sneakeryard.screens

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.sneakeryard.R
import com.github.florent37.camerafragment.CameraFragment
import com.github.florent37.camerafragment.PreviewActivity
import com.github.florent37.camerafragment.configuration.Configuration
import com.github.florent37.camerafragment.listeners.CameraFragmentResultListener
import kotlinx.android.synthetic.main.camera_activity.*

@SuppressLint("MissingPermission")

class CameraActivity : AppCompatActivity() {

    private lateinit var cameraFragment : CameraFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_take_photo.setOnClickListener { takeNewPhoto() }
        hasPermissionAndOpenCamera()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivityCameraFragment()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this, "Camera success!", Toast.LENGTH_SHORT).show()
    }

    /**
     * Check if you have Camera Permission
     *      if you don't have it then permission is requested
     */
    private fun hasPermissionAndOpenCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED) {
            startActivityCameraFragment()
        } else {
            requestPermission()
        }
    }

    /**
     * Call the fragment that has the component of CameraFragment on layout
     */
    private fun startActivityCameraFragment() {
        cameraFragment = CameraFragment.newInstance(Configuration.Builder().build())
        supportFragmentManager.beginTransaction().replace(R.id.content, cameraFragment, "Nothing")
            .commit()
    }

    /**
     * Requesting permission to open the Camera and show Dialog on screen
     */
    private fun requestPermission() {
        val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        ActivityCompat.requestPermissions(this, permissions, PackageManager.PERMISSION_GRANTED)
    }

    private fun takeNewPhoto() {
        cameraFragment.takePhotoOrCaptureVideo(callBackListener, "/storage/self/primary", "photo_test0")
    }

    private var callBackListener: CameraFragmentResultListener = object: CameraFragmentResultListener {

        override fun onVideoRecorded(filePath: String?) {
            println(filePath)
        }

        override fun onPhotoTaken(bytes: ByteArray?, filePath: String?) {
            val intent = PreviewActivity.newIntentPhoto(this@CameraActivity, filePath)
            startActivityForResult(intent, 200)
        }
    }
}