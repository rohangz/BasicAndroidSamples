package com.rinfinity.basicandroidsamples.adapter

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.adapter.viewholders.BasicSampleItemViewHolder

abstract class BaseAdapter(protected val list: ArrayList<Any>, protected val mContext: Context) :
    RecyclerView.Adapter<BasicSampleItemViewHolder>() {

    var mItemTouchHelper: ItemTouchHelper? = null

    final override fun getItemCount(): Int = list.size

    final override fun onBindViewHolder(holder: BasicSampleItemViewHolder, position: Int) =
        holder.bindData(list[position], position)
}