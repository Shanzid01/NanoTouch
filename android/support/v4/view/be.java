package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
class be extends bd {
    static Field f227b;
    static boolean f228c = false;

    be() {
    }

    public boolean mo256a(View view, int i) {
        return bn.m757a(view, i);
    }

    public boolean mo259b(View view, int i) {
        return bn.m758b(view, i);
    }

    public void mo252a(View view, C0120a c0120a) {
        bn.m756a(view, c0120a.m491a());
    }

    public boolean mo258b(View view) {
        boolean z = true;
        if (f228c) {
            return false;
        }
        if (f227b == null) {
            try {
                f227b = View.class.getDeclaredField("mAccessibilityDelegate");
                f227b.setAccessible(true);
            } catch (Throwable th) {
                f228c = true;
                return false;
            }
        }
        try {
            if (f227b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            f228c = true;
            return false;
        }
    }

    public cr mo280r(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        cr crVar = (cr) this.a.get(view);
        if (crVar != null) {
            return crVar;
        }
        crVar = new cr(view);
        this.a.put(view, crVar);
        return crVar;
    }
}
