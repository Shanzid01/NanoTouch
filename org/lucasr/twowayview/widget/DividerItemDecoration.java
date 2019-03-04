package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class DividerItemDecoration extends ar {
    private final Drawable mHorizontalDivider;
    private final ItemSpacingOffsets mItemSpacing;
    private final Drawable mVerticalDivider;

    public DividerItemDecoration(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerItemDecoration(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_DividerItemDecoration, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C2000R.styleable.twowayview_DividerItemDecoration_android_divider);
        if (drawable != null) {
            this.mHorizontalDivider = drawable;
            this.mVerticalDivider = drawable;
        } else {
            this.mVerticalDivider = obtainStyledAttributes.getDrawable(C2000R.styleable.twowayview_DividerItemDecoration_twowayview_verticalDivider);
            this.mHorizontalDivider = obtainStyledAttributes.getDrawable(C2000R.styleable.twowayview_DividerItemDecoration_twowayview_horizontalDivider);
        }
        obtainStyledAttributes.recycle();
        this.mItemSpacing = createSpacing(this.mVerticalDivider, this.mHorizontalDivider);
    }

    public DividerItemDecoration(Drawable drawable) {
        this(drawable, drawable);
    }

    public DividerItemDecoration(Drawable drawable, Drawable drawable2) {
        this.mVerticalDivider = drawable;
        this.mHorizontalDivider = drawable2;
        this.mItemSpacing = createSpacing(this.mVerticalDivider, this.mHorizontalDivider);
    }

    private static ItemSpacingOffsets createSpacing(Drawable drawable, Drawable drawable2) {
        int intrinsicHeight;
        int i = 0;
        if (drawable2 != null) {
            intrinsicHeight = drawable2.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
        }
        if (drawable != null) {
            i = drawable.getIntrinsicWidth();
        }
        ItemSpacingOffsets itemSpacingOffsets = new ItemSpacingOffsets(intrinsicHeight, i);
        itemSpacingOffsets.setAddSpacingAtEnd(true);
        return itemSpacingOffsets;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        BaseLayoutManager baseLayoutManager = (BaseLayoutManager) recyclerView.getLayoutManager();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int decoratedLeft = baseLayoutManager.getDecoratedLeft(childAt);
            int decoratedTop = baseLayoutManager.getDecoratedTop(childAt);
            int decoratedRight = baseLayoutManager.getDecoratedRight(childAt);
            int decoratedBottom = baseLayoutManager.getDecoratedBottom(childAt);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int bottom = (decoratedBottom - childAt.getBottom()) - marginLayoutParams.bottomMargin;
            if (bottom > 0 && decoratedBottom < height) {
                bottom = decoratedBottom - bottom;
                this.mHorizontalDivider.setBounds(decoratedLeft, bottom, decoratedRight, this.mHorizontalDivider.getIntrinsicHeight() + bottom);
                this.mHorizontalDivider.draw(canvas);
            }
            int right = (decoratedRight - childAt.getRight()) - marginLayoutParams.rightMargin;
            if (right > 0 && decoratedRight < width) {
                right = decoratedRight - right;
                this.mVerticalDivider.setBounds(right, decoratedTop, this.mVerticalDivider.getIntrinsicWidth() + right, decoratedBottom);
                this.mVerticalDivider.draw(canvas);
            }
        }
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        this.mItemSpacing.getItemOffsets(rect, i, recyclerView);
    }
}
