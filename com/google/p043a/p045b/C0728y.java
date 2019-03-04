package com.google.p043a.p045b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LinkedTreeMap */
class C0728y extends AbstractSet<Entry<K, V>> {
    final /* synthetic */ C0726w f1894a;

    C0728y(C0726w c0726w) {
        this.f1894a = c0726w;
    }

    public int size() {
        return this.f1894a.f1889c;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new C0729z(this);
    }

    public boolean contains(Object obj) {
        return (obj instanceof Entry) && this.f1894a.m3650a((Entry) obj) != null;
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        ad a = this.f1894a.m3650a((Entry) obj);
        if (a == null) {
            return false;
        }
        this.f1894a.m3651a(a, true);
        return true;
    }

    public void clear() {
        this.f1894a.clear();
    }
}
