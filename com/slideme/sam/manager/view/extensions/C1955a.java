package com.slideme.sam.manager.view.extensions;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: FixedPagerTitleStrip */
public class C1955a extends BitmapDrawable {
    final /* synthetic */ FixedPagerTitleStrip f3602a;
    private Drawable f3603b;

    public C1955a(FixedPagerTitleStrip fixedPagerTitleStrip, Drawable drawable) {
        this.f3602a = fixedPagerTitleStrip;
        this.f3603b = drawable;
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public void draw(Canvas canvas) {
        this.f3603b.draw(canvas);
    }

    public int getOpacity() {
        return this.f3603b.getOpacity();
    }

    public void setAlpha(int i) {
        this.f3603b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3603b.setColorFilter(colorFilter);
    }
}
