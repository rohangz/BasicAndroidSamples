package com.rinfinity.basicandroidsamples.adapter

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.viewholders.BaseViewHolder
import com.rinfinity.basicandroidsamples.adapter.viewholders.GalleryItemViewHolder

class CustomGalleryGridAdapter(private val mCursor: Cursor, private val mContext: Context) :
    RecyclerView.Adapter<BaseViewHolder>() {
    private val columnIndexID: Int = mCursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
    private val uriExternal: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    companion object {
        const val GRID_IMAGE_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        GalleryItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.element_gallery, parent, false),
            mContext
        )

    override fun getItemCount(): Int = mCursor.count

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        val imageId = mCursor.getLong(columnIndexID)
        val uri = Uri.withAppendedPath(uriExternal, "" + imageId)
        holder.bindData(uri, position)
    }

    override fun getItemViewType(position: Int): Int = GRID_IMAGE_ITEM


}