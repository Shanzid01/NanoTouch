package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public class cr {
    static final da f242a;
    private WeakReference<View> f243b;
    private Runnable f244c = null;
    private Runnable f245d = null;
    private int f246e = -1;

    cr(View view) {
        this.f243b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f242a = new cz();
        } else if (i >= 18) {
            f242a = new cx();
        } else if (i >= 16) {
            f242a = new cy();
        } else if (i >= 14) {
            f242a = new cv();
        } else {
            f242a = new ct();
        }
    }

    public cr m814a(long j) {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo310a(this, view, j);
        }
        return this;
    }

    public cr m813a(float f) {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo309a(this, view, f);
        }
        return this;
    }

    public cr m817b(float f) {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo313b(this, view, f);
        }
        return this;
    }

    public cr m819c(float f) {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo314c(this, view, f);
        }
        return this;
    }

    public void m816a() {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo308a(this, view);
        }
    }

    public void m818b() {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo312b(this, view);
        }
    }

    public cr m815a(df dfVar) {
        View view = (View) this.f243b.get();
        if (view != null) {
            f242a.mo311a(this, view, dfVar);
        }
        return this;
    }
}
