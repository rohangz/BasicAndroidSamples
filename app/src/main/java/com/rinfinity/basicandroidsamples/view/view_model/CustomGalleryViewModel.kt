package com.rinfinity.basicandroidsamples.view.view_model

import android.app.Application
import android.content.Context
import android.database.Cursor
import androidx.lifecycle.AndroidViewModel
import com.rinfinity.basicandroidsamples.R

class CustomGalleryViewModel(mApp: Application) : AndroidViewModel(mApp) {

    lateinit var mListener: CustomGalleryListener

    fun setCustomGalleryGrid(context: Context) {
        val cursor = CustomGalleryRepo.loadImages(context)
        if(cursor!=null)
            mListener.onImageLoadSuccess(cursor)
        else
            mListener.onImageLoadError(context.getString(R.string.image_load_error_msg))
    }

    interface CustomGalleryListener {
        fun onImageLoadSuccess(cursor: Cursor)
        fun onImageLoadError(message: String)

    }

}