package com.rinfinity.basicandroidsamples.adapter

import android.content.Context
import android.view.*
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener
import com.rinfinity.basicandroidsamples.adapter.model.NoteData
import com.rinfinity.basicandroidsamples.adapter.viewholders.BasicSampleItemViewHolder
import com.rinfinity.basicandroidsamples.adapter.viewholders.NotesItemViewHolder

class NotesAdapter(mContext: Context, list: ArrayList<Any>) :
    BaseAdapter(list, mContext) {

    companion object {
        @JvmStatic
        val TYPE_NOTE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicSampleItemViewHolder {
        return when (viewType) {
            TYPE_NOTE -> NotesItemViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(
                    R.layout.eleement_note, parent,
                    false
                ),
                mContext,
                this
            )
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is NoteData -> TYPE_NOTE
            else -> super.getItemViewType(position)
        }
    }

}