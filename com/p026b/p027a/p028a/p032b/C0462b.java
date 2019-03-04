package com.p026b.p027a.p028a.p032b;

import com.p026b.p027a.p041c.C0524d;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LimitedMemoryCache */
public abstract class C0462b<K, V> extends C0461a<K, V> {
    private final int f1404a;
    private final AtomicInteger f1405b;
    private final List<V> f1406c = Collections.synchronizedList(new LinkedList());

    protected abstract V mo923c();

    protected abstract int mo925d(V v);

    public C0462b(int i) {
        this.f1404a = i;
        this.f1405b = new AtomicInteger();
        if (i > 16777216) {
            C0524d.m3154c("You set too large memory cache size (more than %1$d Mb)", Integer.valueOf(16));
        }
    }

    public boolean mo921a(K k, V v) {
        boolean z = false;
        int d = mo925d(v);
        int b = m2915b();
        int i = this.f1405b.get();
        if (d < b) {
            int i2 = i;
            while (i2 + d > b) {
                Object c = mo923c();
                if (this.f1406c.remove(c)) {
                    i2 = this.f1405b.addAndGet(-mo925d(c));
                }
            }
            this.f1406c.add(v);
            this.f1405b.addAndGet(d);
            z = true;
        }
        super.mo921a(k, v);
        return z;
    }

    public void mo922b(K k) {
        Object a = super.mo919a(k);
        if (a != null && this.f1406c.remove(a)) {
            this.f1405b.addAndGet(-mo925d(a));
        }
        super.mo922b(k);
    }

    protected int m2915b() {
        return this.f1404a;
    }
}
