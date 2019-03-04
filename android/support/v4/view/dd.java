package android.support.v4.view;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
class dd {
    public static void m859a(View view, df dfVar) {
        if (dfVar != null) {
            view.animate().setListener(new de(dfVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
