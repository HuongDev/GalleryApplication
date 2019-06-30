package vn.com.huong.galleryapplication

import android.graphics.Rect
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

/**
 * Created by HuongPN on 01/21/2019.
 */
class GridItemDecoration(private var offset: Int): androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val layoutPrams = view.layoutParams as androidx.recyclerview.widget.GridLayoutManager.LayoutParams

        if (layoutPrams.spanIndex.div(2) == 0) {

            // Right
            outRect.top = offset
            outRect.left = offset / 2
            outRect.right = offset / 2
        } else {

            // Item of column left
            outRect.top = offset
            outRect.right = offset / 2
            outRect.left = offset / 2
        }
    }
}