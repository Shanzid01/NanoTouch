package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.slideme.sam.manager.C1608b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Masonry extends ViewGroup {
    private boolean f3704a;
    private int f3705b;
    private int f3706c;
    private int f3707d;
    private boolean f3708e;
    private int f3709f;
    private List<Integer> f3710g;
    private List<C1988v> f3711h;
    private ExecutorService f3712i = Executors.newSingleThreadExecutor();

    public Masonry(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.Masonry);
        this.f3706c = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f3705b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f3707d = obtainStyledAttributes.getInteger(0, 0);
        this.f3708e = obtainStyledAttributes.getBoolean(3, false);
        this.f3709f = obtainStyledAttributes.getInt(4, 500);
        obtainStyledAttributes.recycle();
    }

    public int getColumnWidth() {
        return this.f3705b;
    }

    public void setColumnWidth(int i) {
        this.f3705b = i;
    }

    public int getGutter() {
        return this.f3706c;
    }

    public void setGutter(int i) {
        this.f3706c = i;
    }

    public void setAnimated(boolean z) {
        this.f3708e = z;
    }

    public int getDuration() {
        return this.f3709f;
    }

    public void setDuration(int i) {
        this.f3709f = i;
    }

    public int getColumns() {
        return this.f3707d;
    }

    public void setColumns(int i) {
        this.f3707d = i;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        measureChildren(0, 0);
        List<View> arrayList = new ArrayList();
        for (i3 = 0; i3 < getChildCount(); i3++) {
            arrayList.add(getChildAt(i3));
        }
        int measuredWidth = getMeasuredWidth() > 0 ? getMeasuredWidth() : MeasureSpec.getSize(i);
        if (this.f3707d > 0) {
            this.f3705b = (measuredWidth - (this.f3707d * this.f3706c)) / this.f3707d;
        } else {
            if (this.f3705b == 0) {
                this.f3705b = (arrayList.isEmpty() ? measuredWidth : ((View) arrayList.get(0)).getMeasuredWidth()) + this.f3706c;
            }
            this.f3707d = Math.max(Double.valueOf(Math.floor(((double) (this.f3706c + measuredWidth)) / ((double) this.f3705b))).intValue(), 1);
        }
        this.f3710g = new ArrayList();
        for (i3 = 0; i3 < this.f3707d; i3++) {
            this.f3710g.add(Integer.valueOf(0));
        }
        this.f3711h = new ArrayList();
        for (View view : arrayList) {
            int min = Math.min(Double.valueOf(Math.ceil(((double) view.getMeasuredWidth()) / ((double) this.f3705b))).intValue(), this.f3707d);
            if (min == 1) {
                m5976a(view, this.f3710g, this.f3711h);
            } else {
                int i4 = (this.f3707d - min) + 1;
                List arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    arrayList2.add((Integer) Collections.max(this.f3710g.subList(i5, i5 + min)));
                }
                m5976a(view, arrayList2, this.f3711h);
            }
        }
        if (MeasureSpec.getMode(i2) == 0) {
            i2 = MeasureSpec.makeMeasureSpec(((Integer) Collections.max(this.f3710g)).intValue(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3704a && this.f3708e) {
            this.f3712i.submit(new C1984r(this));
            return;
        }
        this.f3704a = true;
        for (C1988v c1988v : this.f3711h) {
            C1987u c1987u = c1988v.f3851b;
            View view = c1988v.f3850a;
            int i5 = c1987u.f3849b;
            int i6 = c1987u.f3848a;
            view.layout(i5, i6, view.getMeasuredWidth() + i5, view.getMeasuredHeight() + i6);
        }
    }

    private void m5976a(View view, List<Integer> list, List<C1988v> list2) {
        int i;
        int i2;
        int i3 = 0;
        int intValue = ((Integer) Collections.min(list)).intValue();
        int size = list.size();
        for (i = 0; i < size; i++) {
            if (((Integer) list.get(i)).intValue() == intValue) {
                i2 = i;
                break;
            }
        }
        i2 = 0;
        C1987u c1987u = new C1987u();
        c1987u.f3848a = view.getTop();
        c1987u.f3849b = view.getLeft();
        c1987u = new C1987u();
        c1987u.f3848a = intValue;
        c1987u.f3849b = this.f3705b * i2;
        C1988v c1988v = new C1988v();
        c1988v.f3850a = view;
        c1988v.f3851b = c1987u;
        list2.add(c1988v);
        i = (this.f3706c + intValue) + view.getMeasuredHeight();
        intValue = (this.f3707d + 1) - size;
        while (i3 < intValue) {
            this.f3710g.set(i2 + i3, Integer.valueOf(i));
            i3++;
        }
    }
}
