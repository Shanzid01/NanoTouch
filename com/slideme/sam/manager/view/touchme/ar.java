package com.slideme.sam.manager.view.touchme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* compiled from: SlidingTabSelector */
class ar extends Drawable {
    final /* synthetic */ SlidingTabSelector f3795a;
    private RectF f3796b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private int f3797c = 0;
    private int f3798d = 0;
    private Paint f3799e = new Paint();
    private Bitmap f3800f = null;
    private boolean f3801g = false;
    private at f3802h = new at(this);
    private Handler f3803i = new Handler();
    private Runnable f3804j = new as(this);

    public void m6092a(float f, float f2) {
        this.f3802h.f3807b = f;
        this.f3802h.f3806a = f2;
        this.f3802h.m6097b();
        this.f3803i.post(this.f3804j);
    }

    public ar(SlidingTabSelector slidingTabSelector) {
        this.f3795a = slidingTabSelector;
        this.f3799e.setAntiAlias(true);
        this.f3799e.setStyle(Style.FILL);
        this.f3802h.m6096a(150);
    }

    public void m6094a(Bitmap bitmap) {
        this.f3800f = bitmap;
        if (this.f3800f != null) {
            int i = this.f3795a.getContext().getResources().getDisplayMetrics().densityDpi;
            m6079a(this.f3800f.getScaledHeight(i), this.f3800f.getScaledWidth(i));
            m6083b((float) ((this.f3795a.getMeasuredHeight() - this.f3797c) / 2), m6082b() - ((float) (this.f3798d / 2)));
        }
    }

    private float m6082b() {
        return this.f3796b.left + ((float) (this.f3798d / 2));
    }

    private void m6078a(float f) {
        float f2 = 0.0f;
        float f3 = f - ((float) (this.f3798d / 2));
        if (f3 >= 0.0f) {
            f2 = f3 > ((float) (this.f3795a.getWidth() - this.f3798d)) ? (float) (this.f3795a.getWidth() - this.f3798d) : f3;
        }
        m6083b(this.f3796b.top, f2);
    }

    private void m6079a(int i, int i2) {
        this.f3797c = i;
        this.f3798d = i2;
        this.f3796b.right = ((float) this.f3798d) + this.f3796b.left;
        this.f3796b.bottom = ((float) this.f3797c) + this.f3796b.top;
    }

    private void m6083b(float f, float f2) {
        this.f3796b.bottom = ((float) this.f3797c) + f;
        this.f3796b.top = f;
        this.f3796b.right = ((float) this.f3798d) + f2;
        this.f3796b.left = f2;
    }

    public RectF m6091a() {
        return this.f3796b;
    }

    public void m6093a(int i) {
        this.f3799e.setColor(i);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f3800f, null, m6091a(), this.f3799e);
    }

    private void m6086c() {
        m6078a(this.f3802h.f3807b + (this.f3802h.m6099d() * this.f3802h.m6098c()));
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
