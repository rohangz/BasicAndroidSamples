package com.rinfinity.basicandroidsamples.adapter.viewholders

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.element_gallery.view.*

class GalleryItemViewHolder(root: View, mContext: Context) : BaseViewHolder(root, mContext) {

    private val mGalleryImage: ImageView = root.image_item_gallery

    override fun bindData(data: Any, position: Int) {
        if(data is Uri)
            mGalleryImage.setImageURI(data)
    }

}