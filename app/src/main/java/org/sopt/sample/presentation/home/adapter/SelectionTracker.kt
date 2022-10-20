package org.sopt.sample.presentation.home.adapter

import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView

fun setSelectionTracker(id: String, recyclerView: RecyclerView): SelectionTracker<Long> {
    val tracker = SelectionTracker.Builder(
        id,
        recyclerView,
        StableIdKeyProvider(recyclerView),
        GitDetailsLookUp(recyclerView),
        StorageStrategy.createLongStorage()
    ).withSelectionPredicate(object : SelectionTracker.SelectionPredicate<Long>() {
        override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
            return true
        }

        override fun canSetStateAtPosition(
            position: Int, nextState: Boolean
        ): Boolean {
            return true
        }

        override fun canSelectMultiple(): Boolean {
            return true
        }
    }).build()
    return tracker
}