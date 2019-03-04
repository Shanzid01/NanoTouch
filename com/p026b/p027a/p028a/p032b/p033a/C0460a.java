package com.p026b.p027a.p028a.p032b.p033a;

import com.p026b.p027a.p028a.p032b.C0459c;
import java.util.Collection;
import java.util.Comparator;

/* compiled from: FuzzyKeyMemoryCache */
public class C0460a<K, V> implements C0459c<K, V> {
    private final C0459c<K, V> f1401a;
    private final Comparator<K> f1402b;

    public C0460a(C0459c<K, V> c0459c, Comparator<K> comparator) {
        this.f1401a = c0459c;
        this.f1402b = comparator;
    }

    public boolean mo921a(K k, V v) {
        synchronized (this.f1401a) {
            for (Object next : this.f1401a.mo920a()) {
                if (this.f1402b.compare(k, next) == 0) {
                    break;
                }
            }
            Object next2 = null;
            if (next2 != null) {
                this.f1401a.mo922b(next2);
            }
        }
        return this.f1401a.mo921a(k, v);
    }

    public V mo919a(K k) {
        return this.f1401a.mo919a(k);
    }

    public void mo922b(K k) {
        this.f1401a.mo922b(k);
    }

    public Collection<K> mo920a() {
        return this.f1401a.mo920a();
    }
}
