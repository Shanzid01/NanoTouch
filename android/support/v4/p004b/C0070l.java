package android.support.v4.p004b;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: MapCollections */
final class C0070l implements Collection<V> {
    final /* synthetic */ C0060g f77a;

    C0070l(C0060g c0060g) {
        this.f77a = c0060g;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f77a.mo164c();
    }

    public boolean contains(Object obj) {
        return this.f77a.mo162b(obj) >= 0;
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
        return this.f77a.mo156a() == 0;
    }

    public Iterator<V> iterator() {
        return new C0066h(this.f77a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f77a.mo162b(obj);
        if (b < 0) {
            return false;
        }
        this.f77a.mo160a(b);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.f77a.mo156a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f77a.mo158a(i, 1))) {
                this.f77a.mo160a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.f77a.mo156a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f77a.mo158a(i, 1))) {
                this.f77a.mo160a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f77a.mo156a();
    }

    public Object[] toArray() {
        return this.f77a.m77b(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f77a.m74a((Object[]) tArr, 1);
    }
}
