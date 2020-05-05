package com.rinfinity.basicandroidsamples.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.rinfinity.basicandroidsamples.R
import com.rinfinity.basicandroidsamples.adapter.GridAdapter
import com.rinfinity.basicandroidsamples.adapter.GridItemTouchHelper
import com.rinfinity.basicandroidsamples.adapter.model.GridItemData
import kotlinx.android.synthetic.main.activity_grid.*

class GridActivity : AppCompatActivity() {

    private lateinit var mAdapter: GridAdapter
    private lateinit var mItemTouchHelperCallback: ItemTouchHelper.Callback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        initUI()
    }

    private fun initUI() {
        mAdapter = GridAdapter(this, getList())
        mItemTouchHelperCallback = GridItemTouchHelper(mAdapter)
        grid_view.layoutManager = GridLayoutManager(this, 3)
        mAdapter.mItemTouchHelper = ItemTouchHelper(mItemTouchHelperCallback)
        mAdapter.mItemTouchHelper?.attachToRecyclerView(grid_view)
        grid_view.adapter = mAdapter
    }


    private fun getList():  ArrayList<Any> {
        val list = ArrayList<Any>()
        repeat(10) {
            val k =it + 1
            list.add(GridItemData(k.toString()))
        }
        return list
    }
}
