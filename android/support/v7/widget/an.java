package android.support.v7.widget;

import java.util.ArrayList;

/* compiled from: RecyclerView */
public abstract class an {
    private ap f586a = null;
    private ArrayList<ao> f587b = new ArrayList();
    private long f588c = 120;
    private long f589d = 120;
    private long f590e = 250;
    private long f591f = 250;
    private boolean f592g = false;

    public abstract void mo453a();

    public abstract boolean mo454a(bg bgVar);

    public abstract boolean mo455a(bg bgVar, int i, int i2, int i3, int i4);

    public abstract boolean mo456a(bg bgVar, bg bgVar2, int i, int i2, int i3, int i4);

    public abstract boolean mo457b();

    public abstract boolean mo458b(bg bgVar);

    public abstract void mo459c();

    public abstract void mo460c(bg bgVar);

    public long m1553d() {
        return this.f590e;
    }

    public long m1556e() {
        return this.f588c;
    }

    public long m1558f() {
        return this.f589d;
    }

    public long m1560g() {
        return this.f591f;
    }

    public boolean m1563h() {
        return this.f592g;
    }

    void m1542a(ap apVar) {
        this.f586a = apVar;
    }

    public final void m1554d(bg bgVar) {
        m1567k(bgVar);
        if (this.f586a != null) {
            this.f586a.mo443a(bgVar);
        }
    }

    public final void m1557e(bg bgVar) {
        m1571o(bgVar);
        if (this.f586a != null) {
            this.f586a.mo445c(bgVar);
        }
    }

    public final void m1559f(bg bgVar) {
        m1569m(bgVar);
        if (this.f586a != null) {
            this.f586a.mo444b(bgVar);
        }
    }

    public final void m1543a(bg bgVar, boolean z) {
        m1555d(bgVar, z);
        if (this.f586a != null) {
            this.f586a.mo446d(bgVar);
        }
    }

    public final void m1561g(bg bgVar) {
        m1566j(bgVar);
    }

    public final void m1562h(bg bgVar) {
        m1570n(bgVar);
    }

    public final void m1565i(bg bgVar) {
        m1568l(bgVar);
    }

    public final void m1547b(bg bgVar, boolean z) {
        m1552c(bgVar, z);
    }

    public final void m1564i() {
        int size = this.f587b.size();
        for (int i = 0; i < size; i++) {
            ((ao) this.f587b.get(i)).m1572a();
        }
        this.f587b.clear();
    }

    public void m1566j(bg bgVar) {
    }

    public void m1567k(bg bgVar) {
    }

    public void m1568l(bg bgVar) {
    }

    public void m1569m(bg bgVar) {
    }

    public void m1570n(bg bgVar) {
    }

    public void m1571o(bg bgVar) {
    }

    public void m1552c(bg bgVar, boolean z) {
    }

    public void m1555d(bg bgVar, boolean z) {
    }
}
