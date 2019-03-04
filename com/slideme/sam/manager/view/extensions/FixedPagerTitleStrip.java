package com.slideme.sam.manager.view.extensions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerTitleStrip;
import android.util.AttributeSet;

public class FixedPagerTitleStrip extends PagerTitleStrip {
    public FixedPagerTitleStrip(Context context) {
        super(context);
    }

    public FixedPagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Drawable getBackground() {
        return new C1955a(this, super.getBackground());
    }
}
