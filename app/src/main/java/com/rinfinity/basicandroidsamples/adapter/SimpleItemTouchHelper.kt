package com.rinfinity.basicandroidsamples.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener

class SimpleItemTouchHelper(drags: Int, swipeDirs: Int, private val mListener: ItemTouchHelperListener) :
    ItemTouchHelper.SimpleCallback(drags, swipeDirs) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) =
        mListener.onItemSwiped(viewHolder.adapterPosition)


}