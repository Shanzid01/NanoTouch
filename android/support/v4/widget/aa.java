package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompatIcs */
class aa {
    public static Object m1034a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m1035a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m1036a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m1040b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m1037a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m1041c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m1038a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m1039a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
