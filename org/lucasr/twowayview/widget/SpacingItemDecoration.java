package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ar;
import android.util.AttributeSet;

public class SpacingItemDecoration extends ar {
    private final ItemSpacingOffsets mItemSpacing;

    public SpacingItemDecoration(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpacingItemDecoration(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_SpacingItemDecoration, i, 0);
        int max = Math.max(0, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_SpacingItemDecoration_android_verticalSpacing, 0));
        int max2 = Math.max(0, obtainStyledAttributes.getInt(C2000R.styleable.twowayview_SpacingItemDecoration_android_horizontalSpacing, 0));
        obtainStyledAttributes.recycle();
        this.mItemSpacing = new ItemSpacingOffsets(max, max2);
    }

    public SpacingItemDecoration(int i, int i2) {
        this.mItemSpacing = new ItemSpacingOffsets(i, i2);
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        this.mItemSpacing.getItemOffsets(rect, i, recyclerView);
    }
}
