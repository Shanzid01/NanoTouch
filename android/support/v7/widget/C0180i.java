package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class C0180i implements Runnable {
    final /* synthetic */ ArrayList f683a;
    final /* synthetic */ C0178g f684b;

    C0180i(C0178g c0178g, ArrayList arrayList) {
        this.f684b = c0178g;
        this.f683a = arrayList;
    }

    public void run() {
        Iterator it = this.f683a.iterator();
        while (it.hasNext()) {
            this.f684b.m1759a((C0188p) it.next());
        }
        this.f683a.clear();
        this.f684b.f676g.remove(this.f683a);
    }
}
