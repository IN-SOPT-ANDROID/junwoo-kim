package org.sopt.sample.presentation.home.adapter

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView


class GitDetailsLookUp(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {

    override fun getItemDetails(motionEvent: MotionEvent): ItemDetails<Long>? {
        val view: View? = recyclerView!!.findChildViewUnder(motionEvent.x, motionEvent.y)
        if (view != null) {
            return if (recyclerView.getChildViewHolder(view) is GitAdapter.HeaderViewHolder)
            // Header 타입은 터치 이벤트가 없기때문에 넣지 않음
            {
                null
            } else {
                (recyclerView.getChildViewHolder(view) as GitAdapter.ItemViewHolder).getItemDetails()
            }
        }
        return null
    }
}