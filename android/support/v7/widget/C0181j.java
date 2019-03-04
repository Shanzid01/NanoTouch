package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class C0181j implements Runnable {
    final /* synthetic */ ArrayList f685a;
    final /* synthetic */ C0178g f686b;

    C0181j(C0178g c0178g, ArrayList arrayList) {
        this.f686b = c0178g;
        this.f685a = arrayList;
    }

    public void run() {
        Iterator it = this.f685a.iterator();
        while (it.hasNext()) {
            this.f686b.m1773q((bg) it.next());
        }
        this.f685a.clear();
        this.f686b.f674e.remove(this.f685a);
    }
}
