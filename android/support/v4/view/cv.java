package android.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
class cv extends ct {
    WeakHashMap<View, Integer> f251b = null;

    cv() {
    }

    public void mo310a(cr crVar, View view, long j) {
        db.m854a(view, j);
    }

    public void mo309a(cr crVar, View view, float f) {
        db.m853a(view, f);
    }

    public void mo313b(cr crVar, View view, float f) {
        db.m857b(view, f);
    }

    public void mo314c(cr crVar, View view, float f) {
        db.m858c(view, f);
    }

    public void mo308a(cr crVar, View view) {
        db.m852a(view);
    }

    public void mo312b(cr crVar, View view) {
        db.m856b(view);
    }

    public void mo311a(cr crVar, View view, df dfVar) {
        view.setTag(2113929216, dfVar);
        db.m855a(view, new cw(crVar));
    }
}
