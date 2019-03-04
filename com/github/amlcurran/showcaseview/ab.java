package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;

/* compiled from: StandardShowcaseDrawer */
class ab implements C0643t {
    protected final Paint f1625a = new Paint();
    protected final Drawable f1626b;
    protected int f1627c;
    private final Paint f1628d;
    private final float f1629e;

    public ab(Resources resources) {
        Xfermode porterDuffXfermode = new PorterDuffXfermode(Mode.MULTIPLY);
        this.f1625a.setColor(16777215);
        this.f1625a.setAlpha(0);
        this.f1625a.setXfermode(porterDuffXfermode);
        this.f1625a.setAntiAlias(true);
        this.f1628d = new Paint();
        this.f1629e = resources.getDimension(C0655m.showcase_radius);
        this.f1626b = resources.getDrawable(C0656n.cling_bleached);
    }

    public void mo1092a(int i) {
        this.f1626b.setColorFilter(i, Mode.MULTIPLY);
    }

    public void mo1094a(Bitmap bitmap, float f, float f2, float f3) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(f, f2, this.f1629e, this.f1625a);
        int a = (int) (f - ((float) (mo1091a() / 2)));
        int b = (int) (f2 - ((float) (mo1096b() / 2)));
        this.f1626b.setBounds(a, b, mo1091a() + a, mo1096b() + b);
        this.f1626b.draw(canvas);
    }

    public int mo1091a() {
        return this.f1626b.getIntrinsicWidth();
    }

    public int mo1096b() {
        return this.f1626b.getIntrinsicHeight();
    }

    public float mo1098c() {
        return this.f1629e;
    }

    public void mo1097b(int i) {
        this.f1627c = i;
    }

    public void mo1093a(Bitmap bitmap) {
        bitmap.eraseColor(this.f1627c);
    }

    public void mo1095a(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f1628d);
    }
}
