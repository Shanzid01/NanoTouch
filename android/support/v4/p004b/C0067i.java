package android.support.v4.p004b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
final class C0067i implements Set<Entry<K, V>> {
    final /* synthetic */ C0060g f71a;

    C0067i(C0060g c0060g) {
        this.f71a = c0060g;
    }

    public /* synthetic */ boolean add(Object obj) {
        return m99a((Entry) obj);
    }

    public boolean m99a(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int a = this.f71a.mo156a();
        for (Entry entry : collection) {
            this.f71a.mo161a(entry.getKey(), entry.getValue());
        }
        return a != this.f71a.mo156a();
    }

    public void clear() {
        this.f71a.mo164c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f71a.mo157a(entry.getKey());
        if (a >= 0) {
            return C0062c.m94a(this.f71a.mo158a(a, 1), entry.getValue());
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f71a.mo156a() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new C0069k(this.f71a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f71a.mo156a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return C0060g.m65a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f71a.mo156a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f71a.mo158a(a, 0);
            Object a3 = this.f71a.mo158a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }
}
