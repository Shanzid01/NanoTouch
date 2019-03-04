package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompatJB */
class bo {
    public static boolean m763a(View view) {
        return view.hasTransientState();
    }

    public static void m764b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m760a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m761a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m762a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m765c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m759a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static ViewParent m766d(View view) {
        return view.getParentForAccessibility();
    }

    public static int m767e(View view) {
        return view.getMinimumWidth();
    }

    public static int m768f(View view) {
        return view.getMinimumHeight();
    }

    public static boolean m769g(View view) {
        return view.getFitsSystemWindows();
    }
}
