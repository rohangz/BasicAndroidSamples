package com.rinfinity.basicandroidsamples.adapter.viewholders

import android.content.Context
import android.view.View
import android.widget.TextView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener
import com.rinfinity.basicandroidsamples.adapter.model.GridItemData
import kotlinx.android.synthetic.main.element_grid.view.*

class GridItemViewHolder(
    root: View,
    mContext: Context,
    mListener: ItemTouchHelperListener
) : BasicSampleItemViewHolder(root, mContext, mListener) {

    private val mData: TextView = root.element_grid_title

    override fun bindData(data: Any, position: Int) {
        if (data is GridItemData) {
            mData.text = data.data
        }
    }

}