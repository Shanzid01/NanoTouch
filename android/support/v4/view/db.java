package android.support.v4.view;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatICS */
class db {
    public static void m854a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m853a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m857b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m858c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void m852a(View view) {
        view.animate().cancel();
    }

    public static void m856b(View view) {
        view.animate().start();
    }

    public static void m855a(View view, df dfVar) {
        if (dfVar != null) {
            view.animate().setListener(new dc(dfVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
