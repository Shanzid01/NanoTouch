package com.google.p043a.p045b;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: LinkedTreeMap */
final class aa extends AbstractSet<K> {
    final /* synthetic */ C0726w f1817a;

    aa(C0726w c0726w) {
        this.f1817a = c0726w;
    }

    public int size() {
        return this.f1817a.f1889c;
    }

    public Iterator<K> iterator() {
        return new ab(this);
    }

    public boolean contains(Object obj) {
        return this.f1817a.containsKey(obj);
    }

    public boolean remove(Object obj) {
        return this.f1817a.m3652b(obj) != null;
    }

    public void clear() {
        this.f1817a.clear();
    }
}
