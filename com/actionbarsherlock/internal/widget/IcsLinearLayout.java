package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;

public class IcsLinearLayout extends NineLinearLayout {
    private static final int LinearLayout_divider = 0;
    private static final int LinearLayout_dividerPadding = 3;
    private static final int LinearLayout_measureWithLargestChild = 1;
    private static final int LinearLayout_showDividers = 2;
    private static final int[] R_styleable_LinearLayout = new int[]{16843049, 16843476, 16843561, 16843562};
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mShowDividers;
    private boolean mUseLargestChild;

    public IcsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R_styleable_LinearLayout);
        setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.mShowDividers = obtainStyledAttributes.getInt(2, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
            invalidate();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (hasDividerBeforeChildAt(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.mDividerHeight;
            } else {
                layoutParams.leftMargin = this.mDividerWidth;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && hasDividerBeforeChildAt(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.mDividerHeight;
            } else {
                layoutParams.rightMargin = this.mDividerWidth;
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (getOrientation() == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
        super.onDraw(canvas);
    }

    void drawDividersVertical(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(childCount)) {
            int height;
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                height = childAt2.getBottom();
            }
            drawHorizontalDivider(canvas, height);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawVerticalDivider(canvas, childAt.getLeft() - ((LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(childCount)) {
            int width;
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                width = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                width = childAt2.getRight();
            }
            drawVerticalDivider(canvas, width);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mUseLargestChild) {
            switch (getOrientation()) {
                case 0:
                    useLargestChildHorizontal();
                    return;
                case 1:
                    useLargestChildVertical();
                    return;
                default:
                    return;
            }
        }
    }

    private void useLargestChildHorizontal() {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            i++;
            i2 = Math.max(getChildAt(i).getMeasuredWidth(), i2);
        }
        int i3 = 0;
        i = 0;
        while (i3 < childCount) {
            int i4;
            View childAt = getChildAt(i3);
            if (childAt == null) {
                i4 = i;
            } else if (childAt.getVisibility() == 8) {
                i4 = i;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.weight > 0.0f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                    i += i2;
                } else {
                    i += childAt.getMeasuredWidth();
                }
                i4 = (layoutParams.rightMargin + layoutParams.leftMargin) + i;
            }
            i3++;
            i = i4;
        }
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + i, getMeasuredHeight());
    }

    private void useLargestChildVertical() {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            i++;
            i2 = Math.max(getChildAt(i).getMeasuredHeight(), i2);
        }
        int i3 = 0;
        i = 0;
        while (i3 < childCount) {
            int i4;
            View childAt = getChildAt(i3);
            if (childAt == null) {
                i4 = i;
            } else if (childAt.getVisibility() == 8) {
                i4 = i;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.weight > 0.0f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
                    i += i2;
                } else {
                    i += childAt.getMeasuredHeight();
                }
                i4 = (layoutParams.rightMargin + layoutParams.leftMargin) + i;
            }
            i3++;
            i = i4;
        }
        setMeasuredDimension(getMeasuredWidth(), (getPaddingLeft() + getPaddingRight()) + i);
    }
}
