package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

/* compiled from: CircleDrawable */
public abstract class C1548a extends Drawable {
    private final Paint f2520a = new Paint();

    public C1548a() {
        this.f2520a.setAntiAlias(true);
        this.f2520a.setStrokeWidth(3.0f);
        this.f2520a.setColor(-1);
        this.f2520a.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) m4650b(), (float) m4651c(), (float) m4652d(), this.f2520a);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    protected Paint m4649a() {
        return this.f2520a;
    }

    protected int m4650b() {
        return getBounds().width() / 2;
    }

    protected int m4651c() {
        return getBounds().height() / 2;
    }

    protected int m4652d() {
        return Math.min(m4650b(), m4651c());
    }
}
