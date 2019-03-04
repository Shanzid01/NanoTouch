package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* compiled from: ScrollerCompat */
public class aj {
    Object f439a;
    ak f440b;

    public static aj m1086a(Context context, Interpolator interpolator) {
        return new aj(context, interpolator);
    }

    aj(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private aj(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f440b = new an();
        } else if (i >= 9) {
            this.f440b = new am();
        } else {
            this.f440b = new al();
        }
        this.f439a = this.f440b.mo339a(context, interpolator);
    }

    public boolean m1089a() {
        return this.f440b.mo342a(this.f439a);
    }

    public int m1090b() {
        return this.f440b.mo343b(this.f439a);
    }

    public int m1091c() {
        return this.f440b.mo344c(this.f439a);
    }

    public int m1092d() {
        return this.f440b.mo348g(this.f439a);
    }

    public int m1093e() {
        return this.f440b.mo349h(this.f439a);
    }

    public float m1094f() {
        return this.f440b.mo345d(this.f439a);
    }

    public boolean m1095g() {
        return this.f440b.mo346e(this.f439a);
    }

    public void m1087a(int i, int i2, int i3, int i4, int i5) {
        this.f440b.mo340a(this.f439a, i, i2, i3, i4, i5);
    }

    public void m1088a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f440b.mo341a(this.f439a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m1096h() {
        this.f440b.mo347f(this.f439a);
    }
}
