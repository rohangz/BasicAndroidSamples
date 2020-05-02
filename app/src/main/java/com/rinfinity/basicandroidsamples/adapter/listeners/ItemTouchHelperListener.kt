package com.rinfinity.basicandroidsamples.adapter.listeners

import android.view.MotionEvent
import com.rinfinity.basicandroidsamples.adapter.viewholders.BasicSampleItemViewHolder

interface ItemTouchHelperListener {

    fun onItemMoved(from: Int, to: Int)
    fun onItemSwiped(swipePosition: Int)
    fun onLongPress(e: MotionEvent?, viewHolder: BasicSampleItemViewHolder)
}