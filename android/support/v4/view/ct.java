package android.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
class ct implements da {
    WeakHashMap<View, Runnable> f247a = null;

    ct() {
    }

    public void mo310a(cr crVar, View view, long j) {
    }

    public void mo309a(cr crVar, View view, float f) {
        m830d(crVar, view);
    }

    public void mo313b(cr crVar, View view, float f) {
        m830d(crVar, view);
    }

    public void mo314c(cr crVar, View view, float f) {
        m830d(crVar, view);
    }

    public void mo308a(cr crVar, View view) {
        m830d(crVar, view);
    }

    public void mo312b(cr crVar, View view) {
        m828a(view);
        m829c(crVar, view);
    }

    public void mo311a(cr crVar, View view, df dfVar) {
        view.setTag(2113929216, dfVar);
    }

    private void m829c(cr crVar, View view) {
        df dfVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof df) {
            dfVar = (df) tag;
        } else {
            dfVar = null;
        }
        Runnable a = crVar.f244c;
        Runnable b = crVar.f245d;
        if (a != null) {
            a.run();
        }
        if (dfVar != null) {
            dfVar.mo315a(view);
            dfVar.mo316b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f247a != null) {
            this.f247a.remove(view);
        }
    }

    private void m828a(View view) {
        if (this.f247a != null) {
            Runnable runnable = (Runnable) this.f247a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m830d(cr crVar, View view) {
        Runnable runnable;
        if (this.f247a != null) {
            runnable = (Runnable) this.f247a.get(view);
        } else {
            runnable = null;
        }
        if (runnable == null) {
            runnable = new cu(this, crVar, view);
            if (this.f247a == null) {
                this.f247a = new WeakHashMap();
            }
            this.f247a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
}
