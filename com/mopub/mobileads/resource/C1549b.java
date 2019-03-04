package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Point;

/* compiled from: CloseButtonDrawable */
public class C1549b extends C1548a {
    private Point f2521a;
    private Point f2522b;
    private Point f2523c;
    private Point f2524d;
    private Point f2525e;
    private final Paint f2526f = new Paint(m4649a());
    private int f2527g;

    public C1549b() {
        this.f2526f.setStrokeWidth(4.5f);
        this.f2526f.setStrokeCap(Cap.ROUND);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f2527g = (int) ((0.5f * ((float) m4652d())) / ((float) Math.sqrt(2.0d)));
        this.f2521a = new Point(m4650b(), m4651c());
        this.f2522b = new Point(this.f2521a);
        this.f2522b.offset(-this.f2527g, this.f2527g);
        this.f2523c = new Point(this.f2521a);
        this.f2523c.offset(-this.f2527g, -this.f2527g);
        this.f2524d = new Point(this.f2521a);
        this.f2524d.offset(this.f2527g, -this.f2527g);
        this.f2525e = new Point(this.f2521a);
        this.f2525e.offset(this.f2527g, this.f2527g);
        canvas.drawLine((float) this.f2522b.x, (float) this.f2522b.y, (float) this.f2524d.x, (float) this.f2524d.y, this.f2526f);
        canvas.drawLine((float) this.f2523c.x, (float) this.f2523c.y, (float) this.f2525e.x, (float) this.f2525e.y, this.f2526f);
    }
}
