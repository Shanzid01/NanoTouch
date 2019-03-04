package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: ViewCompatICS */
class bn {
    public static boolean m757a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m758b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m756a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
