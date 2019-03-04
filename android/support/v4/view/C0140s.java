package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: GravityCompat */
public class C0140s {
    static final C0141t f287a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f287a = new C0143v();
        } else {
            f287a = new C0142u();
        }
    }

    public static int m916a(int i, int i2) {
        return f287a.mo331a(i, i2);
    }
}
