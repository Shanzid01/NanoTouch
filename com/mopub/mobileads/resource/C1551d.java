package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Point;

/* compiled from: LearnMoreDrawable */
public class C1551d extends C1548a {
    private final Paint f2532a = new Paint(m4649a());
    private Point f2533b;
    private Point f2534c;
    private Point f2535d;
    private Point f2536e;
    private Point f2537f;
    private int f2538g;
    private int f2539h;

    public C1551d() {
        this.f2532a.setStrokeWidth(4.5f);
        this.f2532a.setStrokeCap(Cap.ROUND);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f2538g = (int) (((double) (0.5f * ((float) m4652d()))) / Math.sqrt(2.0d));
        this.f2539h = (int) (1.5f * ((float) this.f2538g));
        this.f2533b = new Point(m4650b(), m4651c());
        this.f2534c = new Point(this.f2533b);
        this.f2534c.offset(-this.f2538g, this.f2538g);
        this.f2535d = new Point(this.f2533b);
        this.f2535d.offset(this.f2538g, -this.f2538g);
        this.f2536e = new Point(this.f2535d);
        this.f2536e.offset(-this.f2539h, 0);
        this.f2537f = new Point(this.f2535d);
        this.f2537f.offset(0, this.f2539h);
        canvas.drawLine((float) this.f2534c.x, (float) this.f2534c.y, (float) this.f2535d.x, (float) this.f2535d.y, this.f2532a);
        canvas.drawLine((float) this.f2535d.x, (float) this.f2535d.y, (float) this.f2536e.x, (float) this.f2536e.y, this.f2532a);
        canvas.drawLine((float) this.f2535d.x, (float) this.f2535d.y, (float) this.f2537f.x, (float) this.f2537f.y, this.f2532a);
    }
}
