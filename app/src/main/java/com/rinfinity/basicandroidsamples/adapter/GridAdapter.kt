package com.rinfinity.basicandroidsamples.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener
import com.rinfinity.basicandroidsamples.adapter.model.GridItemData
import com.rinfinity.basicandroidsamples.adapter.viewholders.BasicSampleItemViewHolder
import com.rinfinity.basicandroidsamples.adapter.viewholders.GridItemViewHolder
import java.util.*
import kotlin.collections.ArrayList

class GridAdapter(mContext: Context,list: ArrayList<Any>) :
 BaseAdapter(list, mContext), ItemTouchHelperListener {

    companion object {
        @JvmStatic
        val GRID_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicSampleItemViewHolder {
        return when (viewType) {
            GRID_ITEM -> {
                GridItemViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.element_grid, parent, false)
                    , mContext,
                    this
                )
            }
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is GridItemData -> GRID_ITEM
            else -> super.getItemViewType(position)

        }
    }

    override fun onItemMoved(from: Int, to: Int) {
        Collections.swap(list, from, to)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(swipePosition: Int) {
        list.removeAt(swipePosition)
        notifyItemRemoved(swipePosition)
    }

    override fun onLongPress(e: MotionEvent?, viewHolder: BasicSampleItemViewHolder) {
        mItemTouchHelper?.startDrag(viewHolder)
    }
}