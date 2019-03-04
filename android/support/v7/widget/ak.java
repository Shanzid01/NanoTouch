package android.support.v7.widget;

import android.view.ViewGroup;

/* compiled from: RecyclerView */
public abstract class ak<VH extends bg> {
    private final al f584a = new al();
    private boolean f585b = false;

    public abstract int mo4327a();

    public abstract VH mo4328a(ViewGroup viewGroup, int i);

    public abstract void mo4329a(VH vh, int i);

    public final VH m1531b(ViewGroup viewGroup, int i) {
        VH a = mo4328a(viewGroup, i);
        a.f640e = i;
        return a;
    }

    public final void m1535b(VH vh, int i) {
        vh.f637b = i;
        if (m1536b()) {
            vh.f639d = m1530b(i);
        }
        mo4329a((bg) vh, i);
        vh.m1671a(1, 7);
    }

    public int m1524a(int i) {
        return 0;
    }

    public long m1530b(int i) {
        return -1;
    }

    public final boolean m1536b() {
        return this.f585b;
    }

    public void m1528a(VH vh) {
    }

    public void m1534b(VH vh) {
    }

    public void m1538c(VH vh) {
    }

    public void m1527a(am amVar) {
        this.f584a.registerObserver(amVar);
    }

    public void m1533b(am amVar) {
        this.f584a.unregisterObserver(amVar);
    }

    public void m1526a(RecyclerView recyclerView) {
    }

    public void m1532b(RecyclerView recyclerView) {
    }

    public final void m1537c() {
        this.f584a.m1539a();
    }
}
