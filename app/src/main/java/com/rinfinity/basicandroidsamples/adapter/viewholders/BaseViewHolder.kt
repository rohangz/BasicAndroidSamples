package com.rinfinity.basicandroidsamples.adapter.viewholders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(protected val root: View, protected val mContext: Context) :
    RecyclerView.ViewHolder(root) {
    abstract fun bindData(data: Any, position: Int)
}