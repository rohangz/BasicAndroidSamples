package com.rinfinity.basicandroidsamples.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.ComplexItemTouchHelper
import com.rinfinity.basicandroidsamples.adapter.NotesAdapter
import com.rinfinity.basicandroidsamples.adapter.SimpleItemTouchHelper
import com.rinfinity.basicandroidsamples.adapter.model.NoteData
import kotlinx.android.synthetic.main.activity_notes.*

class ActivityNotes : AppCompatActivity() {

    private lateinit var mAdapter: NotesAdapter
    private lateinit var mItemTouchHelperCallback: ComplexItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        initView()
    }

    private fun initView() {
        val list = ArrayList<Any>()
        repeat(1000) {
            list.add(NoteData("Title ${it+1}","Description ${it+1}"))
        }
        mAdapter = NotesAdapter(this, list)
        notes_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mItemTouchHelperCallback = ComplexItemTouchHelper(mAdapter)
        mAdapter.mItemTouchHelper = ItemTouchHelper(mItemTouchHelperCallback)
        mAdapter.mItemTouchHelper?.attachToRecyclerView(notes_list)
        notes_list.adapter = mAdapter
    }


}
