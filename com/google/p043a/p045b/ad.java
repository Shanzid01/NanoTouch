package com.google.p043a.p045b;

import java.util.Map.Entry;

/* compiled from: LinkedTreeMap */
final class ad<K, V> implements Entry<K, V> {
    ad<K, V> f1823a;
    ad<K, V> f1824b;
    ad<K, V> f1825c;
    ad<K, V> f1826d;
    ad<K, V> f1827e;
    final K f1828f;
    V f1829g;
    int f1830h;

    ad() {
        this.f1828f = null;
        this.f1827e = this;
        this.f1826d = this;
    }

    ad(ad<K, V> adVar, K k, ad<K, V> adVar2, ad<K, V> adVar3) {
        this.f1823a = adVar;
        this.f1828f = k;
        this.f1830h = 1;
        this.f1826d = adVar2;
        this.f1827e = adVar3;
        adVar3.f1826d = this;
        adVar2.f1827e = this;
    }

    public K getKey() {
        return this.f1828f;
    }

    public V getValue() {
        return this.f1829g;
    }

    public V setValue(V v) {
        V v2 = this.f1829g;
        this.f1829g = v;
        return v2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (this.f1828f == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f1828f.equals(entry.getKey())) {
            return false;
        }
        if (this.f1829g == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!this.f1829g.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1828f == null ? 0 : this.f1828f.hashCode();
        if (this.f1829g != null) {
            i = this.f1829g.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return this.f1828f + "=" + this.f1829g;
    }

    public ad<K, V> m3576a() {
        ad<K, V> adVar;
        for (ad<K, V> adVar2 = this.f1824b; adVar2 != null; adVar2 = adVar2.f1824b) {
            adVar = adVar2;
        }
        return adVar;
    }

    public ad<K, V> m3577b() {
        ad<K, V> adVar;
        for (ad<K, V> adVar2 = this.f1825c; adVar2 != null; adVar2 = adVar2.f1825c) {
            adVar = adVar2;
        }
        return adVar;
    }
}
