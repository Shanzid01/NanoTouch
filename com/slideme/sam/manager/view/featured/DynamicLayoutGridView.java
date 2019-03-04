package com.slideme.sam.manager.view.featured;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.GridView;
import com.slideme.sam.manager.model.data.dynamic.DynamicLayout;
import com.slideme.sam.manager.model.data.dynamic.child.LayoutChild;
import java.util.ArrayList;

public class DynamicLayoutGridView extends GridView {
    private DynamicLayout f3604a = null;
    private ArrayList<LayoutChild> f3605b;
    private Activity f3606c;
    private C1957b f3607d;
    private int f3608e = 1;

    public DynamicLayoutGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5867a();
    }

    public DynamicLayoutGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5867a();
    }

    public DynamicLayoutGridView(Context context) {
        super(context);
        m5867a();
    }

    private void m5867a() {
        this.f3607d = new C1957b();
        this.f3608e = getResources().getConfiguration().orientation;
        setDrawSelectorOnTop(true);
        if (this.f3608e == 1) {
            setNumColumns(2);
        } else {
            setNumColumns(3);
        }
        setStretchMode(2);
        int applyDimension = (int) TypedValue.applyDimension(1, 4.0f, getContext().getResources().getDisplayMetrics());
        setVerticalSpacing(applyDimension);
        setHorizontalSpacing(applyDimension);
        setOnItemClickListener(new C1956a(this));
    }

    public void m5871a(DynamicLayout dynamicLayout, Activity activity) {
        this.f3604a = dynamicLayout;
        this.f3606c = activity;
        this.f3605b = this.f3604a.banners.getSorted();
        setAdapter(new C1958c(this));
    }
}
