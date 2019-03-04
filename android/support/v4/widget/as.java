package android.support.v4.widget;

import android.support.v4.view.ay;
import android.view.View;

/* compiled from: SlidingPaneLayout */
class as implements Runnable {
    final View f443a;
    final /* synthetic */ SlidingPaneLayout f444b;

    as(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f444b = slidingPaneLayout;
        this.f443a = view;
    }

    public void run() {
        if (this.f443a.getParent() == this.f444b) {
            ay.m568a(this.f443a, 0, null);
            this.f444b.m985g(this.f443a);
        }
        this.f444b.f357u.remove(this);
    }
}
