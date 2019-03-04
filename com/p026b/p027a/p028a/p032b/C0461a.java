package com.p026b.p027a.p028a.p032b;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: BaseMemoryCache */
public abstract class C0461a<K, V> implements C0459c<K, V> {
    private final Map<K, Reference<V>> f1403a = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<V> mo924c(V v);

    public V mo919a(K k) {
        Reference reference = (Reference) this.f1403a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public boolean mo921a(K k, V v) {
        this.f1403a.put(k, mo924c(v));
        return true;
    }

    public void mo922b(K k) {
        this.f1403a.remove(k);
    }

    public Collection<K> mo920a() {
        Collection hashSet;
        synchronized (this.f1403a) {
            hashSet = new HashSet(this.f1403a.keySet());
        }
        return hashSet;
    }
}
