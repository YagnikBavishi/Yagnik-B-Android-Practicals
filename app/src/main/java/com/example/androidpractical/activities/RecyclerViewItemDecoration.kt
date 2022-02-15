package com.example.androidpractical.activities

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration(space: Int) : RecyclerView.ItemDecoration() {
    private val itemOffset = space
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = itemOffset
        outRect.top = itemOffset
        outRect.right = itemOffset
        outRect.bottom = itemOffset
    }
}