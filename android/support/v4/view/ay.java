package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewCompat */
public class ay {
    static final bi f225a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f225a = new az();
        } else if (i >= 19) {
            f225a = new bh();
        } else if (i >= 17) {
            f225a = new bg();
        } else if (i >= 16) {
            f225a = new bf();
        } else if (i >= 14) {
            f225a = new be();
        } else if (i >= 11) {
            f225a = new bd();
        } else if (i >= 9) {
            f225a = new bc();
        } else if (i >= 7) {
            f225a = new bb();
        } else {
            f225a = new ba();
        }
    }

    public static boolean m574a(View view, int i) {
        return f225a.mo256a(view, i);
    }

    public static boolean m577b(View view, int i) {
        return f225a.mo259b(view, i);
    }

    public static int m565a(View view) {
        return f225a.mo247a(view);
    }

    public static void m570a(View view, C0120a c0120a) {
        f225a.mo252a(view, c0120a);
    }

    public static boolean m576b(View view) {
        return f225a.mo258b(view);
    }

    public static boolean m580c(View view) {
        return f225a.mo262c(view);
    }

    public static void m581d(View view) {
        f225a.mo263d(view);
    }

    public static void m567a(View view, int i, int i2, int i3, int i4) {
        f225a.mo249a(view, i, i2, i3, i4);
    }

    public static void m571a(View view, Runnable runnable) {
        f225a.mo253a(view, runnable);
    }

    public static void m572a(View view, Runnable runnable, long j) {
        f225a.mo254a(view, runnable, j);
    }

    public static int m583e(View view) {
        return f225a.mo265e(view);
    }

    public static void m579c(View view, int i) {
        f225a.mo261c(view, i);
    }

    public static float m585f(View view) {
        return f225a.mo267f(view);
    }

    public static void m568a(View view, int i, Paint paint) {
        f225a.mo250a(view, i, paint);
    }

    public static int m587g(View view) {
        return f225a.mo269g(view);
    }

    public static void m569a(View view, Paint paint) {
        f225a.mo251a(view, paint);
    }

    public static int m588h(View view) {
        return f225a.mo270h(view);
    }

    public static ViewParent m589i(View view) {
        return f225a.mo271i(view);
    }

    public static boolean m590j(View view) {
        return f225a.mo272j(view);
    }

    public static int m591k(View view) {
        return f225a.mo273k(view);
    }

    public static int m592l(View view) {
        return f225a.mo274l(view);
    }

    public static float m593m(View view) {
        return f225a.mo275m(view);
    }

    public static float m594n(View view) {
        return f225a.mo276n(view);
    }

    public static int m595o(View view) {
        return f225a.mo278p(view);
    }

    public static int m596p(View view) {
        return f225a.mo279q(view);
    }

    public static cr m597q(View view) {
        return f225a.mo280r(view);
    }

    public static void m566a(View view, float f) {
        f225a.mo257b(view, f);
    }

    public static void m575b(View view, float f) {
        f225a.mo260c(view, f);
    }

    public static void m578c(View view, float f) {
        f225a.mo264d(view, f);
    }

    public static void m582d(View view, float f) {
        f225a.mo266e(view, f);
    }

    public static void m584e(View view, float f) {
        f225a.mo268f(view, f);
    }

    public static float m598r(View view) {
        return f225a.mo277o(view);
    }

    public static void m586f(View view, float f) {
        f225a.mo248a(view, f);
    }

    public static void m573a(ViewGroup viewGroup, boolean z) {
        f225a.mo255a(viewGroup, z);
    }

    public static boolean m599s(View view) {
        return f225a.mo281s(view);
    }
}
