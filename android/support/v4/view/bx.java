package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupCompat */
public class bx {
    static final cb f231a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f231a = new by();
        } else if (i >= 18) {
            f231a = new cc();
        } else if (i >= 14) {
            f231a = new ca();
        } else if (i >= 11) {
            f231a = new bz();
        } else {
            f231a = new cd();
        }
    }

    public static void m779a(ViewGroup viewGroup, boolean z) {
        f231a.mo295a(viewGroup, z);
    }
}
