package com.rinfinity.basicandroidsamples.adapter.viewholders

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.basicandroidsamples.adapter.listeners.ItemTouchHelperListener

abstract class BasicSampleItemViewHolder(
      root: View,
      mContext: Context,
    protected val mItemTouchHelperListener: ItemTouchHelperListener
) : BaseViewHolder(root, mContext) {

    protected var mGestureDetector: GestureDetector
    protected var mGestureDetectorListener: GestureDetector.OnGestureListener
    protected var mOnTouchListener: View.OnTouchListener

    init {
        mGestureDetectorListener = object : GestureDetector.OnGestureListener {

            override fun onShowPress(e: MotionEvent?) {}

            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                return false
            }

            override fun onDown(e: MotionEvent?): Boolean {
                return false
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent?,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                return false
            }

            override fun onScroll(
                e1: MotionEvent?,
                e2: MotionEvent?,
                distanceX: Float,
                distanceY: Float
            ): Boolean {
                return false
            }

            override fun onLongPress(e: MotionEvent?) {
                mItemTouchHelperListener.onLongPress(e, this@BasicSampleItemViewHolder)
            }

        }
        mGestureDetector = GestureDetector(mContext, mGestureDetectorListener)
        mOnTouchListener = View.OnTouchListener { _, event ->
            mGestureDetector.onTouchEvent(event)
            return@OnTouchListener true
        }

        itemView.setOnTouchListener(mOnTouchListener)
    }

}