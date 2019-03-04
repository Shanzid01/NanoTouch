package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* compiled from: EdgeEffectCompat */
public class C0167w {
    private static final C0168z f500b;
    private Object f501a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f500b = new C0170y();
        } else {
            f500b = new C0169x();
        }
    }

    public C0167w(Context context) {
        this.f501a = f500b.mo368a(context);
    }

    public void m1262a(int i, int i2) {
        f500b.mo369a(this.f501a, i, i2);
    }

    public boolean m1263a() {
        return f500b.mo370a(this.f501a);
    }

    public void m1267b() {
        f500b.mo374b(this.f501a);
    }

    public boolean m1264a(float f) {
        return f500b.mo371a(this.f501a, f);
    }

    public boolean m1268c() {
        return f500b.mo375c(this.f501a);
    }

    public boolean m1265a(int i) {
        return f500b.mo372a(this.f501a, i);
    }

    public boolean m1266a(Canvas canvas) {
        return f500b.mo373a(this.f501a, canvas);
    }
}
