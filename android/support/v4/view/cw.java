package android.support.v4.view;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class cw implements df {
    cr f252a;

    cw(cr crVar) {
        this.f252a = crVar;
    }

    public void mo315a(View view) {
        df dfVar;
        if (this.f252a.f246e >= 0) {
            ay.m568a(view, 2, null);
        }
        if (this.f252a.f244c != null) {
            this.f252a.f244c.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof df) {
            dfVar = (df) tag;
        } else {
            dfVar = null;
        }
        if (dfVar != null) {
            dfVar.mo315a(view);
        }
    }

    public void mo316b(View view) {
        df dfVar;
        if (this.f252a.f246e >= 0) {
            ay.m568a(view, this.f252a.f246e, null);
            this.f252a.f246e = -1;
        }
        if (this.f252a.f245d != null) {
            this.f252a.f245d.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof df) {
            dfVar = (df) tag;
        } else {
            dfVar = null;
        }
        if (dfVar != null) {
            dfVar.mo316b(view);
        }
    }

    public void mo317c(View view) {
        df dfVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof df) {
            dfVar = (df) tag;
        } else {
            dfVar = null;
        }
        if (dfVar != null) {
            dfVar.mo317c(view);
        }
    }
}
