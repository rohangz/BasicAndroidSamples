package com.rinfinity.basicandroidsamples.view.view_model

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore

object CustomGalleryRepo {

    fun loadImages(context: Context): Cursor? {
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID)
        return context.contentResolver.query(uri, projection, null, null, null)
    }
}