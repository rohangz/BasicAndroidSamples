package com.rinfinity.basicandroidsamples.adapter

import android.content.Context
import android.view.MotionEvent
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener
import com.rinfinity.basicandroidsamples.adapter.viewholders.BasicSampleItemViewHolder

abstract class BaseAdapter(protected val list: ArrayList<Any>, protected val mContext: Context) :
    RecyclerView.Adapter<BasicSampleItemViewHolder>(),
    ItemTouchHelperListener {

    var mItemTouchHelper: ItemTouchHelper? = null

    final override fun getItemCount(): Int = list.size

    final override fun onBindViewHolder(holder: BasicSampleItemViewHolder, position: Int) =
        holder.bindData(list[position], position)

    override fun onItemMoved(from: Int, to: Int) {
        val data = list.remove(from)
        list.add(to, data)
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