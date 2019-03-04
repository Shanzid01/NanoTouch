package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.slideme.sam.manager.R;

public class SingleSelectionListLayout extends LinearLayout {
    private ListAdapter f3745a;
    private int f3746b = -1;
    private OnItemSelectedListener f3747c;
    private int f3748d;
    private int f3749e;

    public SingleSelectionListLayout(Context context) {
        super(context);
        m6031a();
    }

    public SingleSelectionListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6031a();
    }

    public SingleSelectionListLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6031a();
    }

    public void m6031a() {
        this.f3749e = (int) TypedValue.applyDimension(1, 3.0f, getContext().getResources().getDisplayMetrics());
        int[] iArr = new int[2];
        iArr[0] = R.attr.secondaryDivider;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(iArr);
        this.f3748d = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
    }

    public void setSelection(int i) {
        this.f3746b = i;
        for (int i2 = 0; i2 < this.f3745a.getCount(); i2++) {
            boolean z;
            View childAt = getChildAt(i2 * 2);
            if (i2 == this.f3746b) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
        if (this.f3746b < 0) {
            this.f3747c.onNothingSelected(null);
        } else {
            this.f3747c.onItemSelected(null, getChildAt(this.f3746b * 2), this.f3746b, 0);
        }
    }

    public int getSelectedItemIndex() {
        return this.f3746b;
    }
}
