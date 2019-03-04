package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
class cu implements Runnable {
    WeakReference<View> f248a;
    cr f249b;
    final /* synthetic */ ct f250c;

    private cu(ct ctVar, cr crVar, View view) {
        this.f250c = ctVar;
        this.f248a = new WeakReference(view);
        this.f249b = crVar;
    }

    public void run() {
        this.f250c.m829c(this.f249b, (View) this.f248a.get());
    }
}
