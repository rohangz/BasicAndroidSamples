package com.rinfinity.basicandroidsamples.adapter.viewholders

import android.content.Context
import android.view.View
import android.widget.TextView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener
import com.rinfinity.basicandroidsamples.adapter.model.NoteData
import kotlinx.android.synthetic.main.eleement_note.view.*

class NotesItemViewHolder(
    root: View,
    mContext: Context,
    mItemTouchHelperListener: ItemTouchHelperListener
) : BasicSampleItemViewHolder(
    root,
    mContext,
    mItemTouchHelperListener
) {

    private val mTitle: TextView = root.title_note
    private val mDescription: TextView = root.description_note

    override fun bindData(data: Any, position: Int) {
        if(data is NoteData) {
            mTitle.text = data.noteTitle
            mDescription.text = data.noteDescription
        }
    }

}