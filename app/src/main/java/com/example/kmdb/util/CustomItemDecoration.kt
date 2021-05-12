package com.example.kmdb.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class CustomItemDecoration(spacing: Int, displayMode: Int?): ItemDecoration() {
    private var mSpacing = 0
    private var mDisplayMode = 0

    val HORIZONTAL = 0
    val VERTICAL = 1
    val GRID = 2

    init {
        mSpacing = spacing
        displayMode!!.let {
            mDisplayMode = displayMode
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildViewHolder(view).adapterPosition
        val itemCount = state.itemCount
        val layoutManager = parent.layoutManager
        setSpacingForDirection(outRect, layoutManager, position, itemCount)
    }

    private fun setSpacingForDirection(
        outRect: Rect,
        layoutManager: RecyclerView.LayoutManager?,
        position: Int,
        itemCount: Int
    ) {

        // Resolve display mode automatically
        if (mDisplayMode == -1) {
            mDisplayMode = resolveDisplayMode(layoutManager)
        }
        when (mDisplayMode) {
            HORIZONTAL -> {
                outRect.left = mSpacing
                outRect.right = if (position == itemCount - 1) mSpacing else 0
                outRect.top = mSpacing
                outRect.bottom = mSpacing
            }
            VERTICAL -> {
                outRect.left = mSpacing
                outRect.right = mSpacing
                outRect.top = mSpacing
                outRect.bottom = if (position == itemCount - 1) mSpacing else 0
            }
            GRID -> if (layoutManager is GridLayoutManager) {
                val cols = layoutManager.spanCount
                val rows = itemCount / cols
                outRect.left = mSpacing
                outRect.right = if (position % cols == cols - 1) mSpacing else 0
                outRect.top = mSpacing
                outRect.bottom = if (position / cols == rows - 1) mSpacing else 0
            }
        }
    }

    private fun resolveDisplayMode(layoutManager: RecyclerView.LayoutManager?): Int {
        if (layoutManager is GridLayoutManager) return GRID
        return if (layoutManager!!.canScrollHorizontally()) HORIZONTAL else VERTICAL
    }
}