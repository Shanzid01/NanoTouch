package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.slideme.sam.manager.view.p064a.C1945p;

public class ScreenshotContainer extends LinearLayout {
    private C1945p f3744a;

    public ScreenshotContainer(Context context) {
        super(context);
        m6028a();
    }

    public ScreenshotContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6028a();
    }

    private void m6028a() {
    }

    public void m6030a(C1945p c1945p) {
        this.f3744a = c1945p;
        m6029b();
    }

    private void m6029b() {
        int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, getContext().getResources().getDisplayMetrics());
        for (int i = 0; i < this.f3744a.getCount(); i++) {
            int i2;
            View view = this.f3744a.getView(i, null, null);
            int paddingLeft = getPaddingLeft() + applyDimension;
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            if (i == this.f3744a.getCount() - 1) {
                i2 = applyDimension;
            } else {
                i2 = 0;
            }
            view.setPadding(paddingLeft, paddingTop, i2 + paddingRight, getPaddingBottom());
            addView(view);
        }
    }
}
