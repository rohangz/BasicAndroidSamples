package com.rinfinity.basicandroidsamples.adapter

import android.graphics.Color
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener

class GridItemTouchHelper(private val mListener: ItemTouchHelperListener) :
    ItemTouchHelper.Callback() {

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.setBackgroundColor(
            Color.WHITE
        )
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        when (actionState) {
            ItemTouchHelper.ACTION_STATE_DRAG -> viewHolder?.itemView?.setBackgroundColor(Color.GRAY)
        }
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
            ItemTouchHelper.START.or(ItemTouchHelper.END).or(ItemTouchHelper.UP)
                .or(ItemTouchHelper.DOWN)
        )
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        mListener.onItemMoved(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

}