package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.actionbarsherlock.C0414R;

public class FakeDialogPhoneWindow extends LinearLayout {
    final TypedValue mMinWidthMajor = new TypedValue();
    final TypedValue mMinWidthMinor = new TypedValue();

    public FakeDialogPhoneWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0414R.styleable.SherlockTheme);
        obtainStyledAttributes.getValue(C0414R.styleable.SherlockTheme_windowMinWidthMajor, this.mMinWidthMajor);
        obtainStyledAttributes.getValue(C0414R.styleable.SherlockTheme_windowMinWidthMinor, this.mMinWidthMinor);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        int dimension;
        Object obj = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj2 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        TypedValue typedValue = obj2 != null ? this.mMinWidthMinor : this.mMinWidthMajor;
        if (typedValue.type != 0) {
            if (typedValue.type == 5) {
                dimension = (int) typedValue.getDimension(displayMetrics);
            } else if (typedValue.type == 6) {
                dimension = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
            } else {
                dimension = 0;
            }
            if (measuredWidth < dimension) {
                dimension = MeasureSpec.makeMeasureSpec(dimension, 1073741824);
                obj = 1;
                if (obj != null) {
                    super.onMeasure(dimension, i2);
                }
            }
        }
        dimension = makeMeasureSpec;
        if (obj != null) {
            super.onMeasure(dimension, i2);
        }
    }
}
