package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView {
    private aa f3722a;

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f3722a != null) {
            this.f3722a.mo4262a();
        }
    }

    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public void m6000a(aa aaVar) {
        this.f3722a = aaVar;
    }
}
