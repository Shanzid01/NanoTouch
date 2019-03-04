package android.support.v4.p004b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: MapCollections */
final class C0068j implements Set<K> {
    final /* synthetic */ C0060g f72a;

    C0068j(C0060g c0060g) {
        this.f72a = c0060g;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f72a.mo164c();
    }

    public boolean contains(Object obj) {
        return this.f72a.mo157a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return C0060g.m64a(this.f72a.mo163b(), (Collection) collection);
    }

    public boolean isEmpty() {
        return this.f72a.mo156a() == 0;
    }

    public Iterator<K> iterator() {
        return new C0066h(this.f72a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f72a.mo157a(obj);
        if (a < 0) {
            return false;
        }
        this.f72a.mo160a(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return C0060g.m66b(this.f72a.mo163b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return C0060g.m67c(this.f72a.mo163b(), collection);
    }

    public int size() {
        return this.f72a.mo156a();
    }

    public Object[] toArray() {
        return this.f72a.m77b(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f72a.m74a((Object[]) tArr, 0);
    }

    public boolean equals(Object obj) {
        return C0060g.m65a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f72a.mo156a() - 1; a >= 0; a--) {
            Object a2 = this.f72a.mo158a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }
}
