package com.rinfinity.basicandroidsamples.view

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.CustomGalleryGridAdapter
import com.rinfinity.basicandroidsamples.view.view_model.CustomGalleryViewModel
import kotlinx.android.synthetic.main.activity_custom_gallery.*

class CustomGalleryActivity : AppCompatActivity(), CustomGalleryViewModel.CustomGalleryListener {

    companion object {
        const val TAG = "CustomGalleryActivity"
        const val READ_EXTERNAL_STORAGE = 1
    }

    private lateinit var mViewModel: CustomGalleryViewModel
    private var mAdapter: CustomGalleryGridAdapter? = null

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_EXTERNAL_STORAGE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    mViewModel.setCustomGalleryGrid(this)
                else
                    Toast.makeText(
                        this,
                        getString(R.string.permission_denied_text),
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_gallery)
        initViewModel()
        checkForStoragePermissions()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(CustomGalleryViewModel::class.java)
        mViewModel.apply {
            mListener = this@CustomGalleryActivity
        }
    }

    private fun checkForStoragePermissions() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_EXTERNAL_STORAGE
            )
        else
            mViewModel.setCustomGalleryGrid(this)
    }

    override fun onImageLoadSuccess(cursor: Cursor) {
        gallery_loader.visibility = View.GONE
        if (cursor.count > 0) {
            gallery_status.visibility = View.GONE
            gallery_grid.visibility = View.VISIBLE
            initGrid(cursor)
        } else {
            gallery_status.visibility = View.VISIBLE
            gallery_status.text = getString(R.string.no_images_found)
        }
    }

    private fun initGrid(cursor: Cursor) {
        mAdapter = CustomGalleryGridAdapter(cursor, this)
        gallery_grid.layoutManager = GridLayoutManager(this, 3, RecyclerView.VERTICAL, false)
        gallery_grid.adapter = mAdapter
    }

    override fun onImageLoadError(message: String) {
        gallery_status.visibility = View.VISIBLE
        gallery_loader.visibility = View.GONE
        gallery_grid.visibility = View.GONE
        gallery_status.text = message
    }
}
