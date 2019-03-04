package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
class C0179h implements Runnable {
    final /* synthetic */ ArrayList f681a;
    final /* synthetic */ C0178g f682b;

    C0179h(C0178g c0178g, ArrayList arrayList) {
        this.f682b = c0178g;
        this.f681a = arrayList;
    }

    public void run() {
        Iterator it = this.f681a.iterator();
        while (it.hasNext()) {
            C0189q c0189q = (C0189q) it.next();
            this.f682b.m1763b(c0189q.f711a, c0189q.f712b, c0189q.f713c, c0189q.f714d, c0189q.f715e);
        }
        this.f681a.clear();
        this.f682b.f675f.remove(this.f681a);
    }
}
