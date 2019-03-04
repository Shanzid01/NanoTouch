package android.support.v4.p004b;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: MapCollections */
final class C0069k implements Iterator<Entry<K, V>>, Entry<K, V> {
    int f73a;
    int f74b;
    boolean f75c = false;
    final /* synthetic */ C0060g f76d;

    public /* synthetic */ Object next() {
        return m100a();
    }

    C0069k(C0060g c0060g) {
        this.f76d = c0060g;
        this.f73a = c0060g.mo156a() - 1;
        this.f74b = -1;
    }

    public boolean hasNext() {
        return this.f74b < this.f73a;
    }

    public Entry<K, V> m100a() {
        this.f74b++;
        this.f75c = true;
        return this;
    }

    public void remove() {
        if (this.f75c) {
            this.f76d.mo160a(this.f74b);
            this.f74b--;
            this.f73a--;
            this.f75c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public K getKey() {
        if (this.f75c) {
            return this.f76d.mo158a(this.f74b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.f75c) {
            return this.f76d.mo158a(this.f74b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V setValue(V v) {
        if (this.f75c) {
            return this.f76d.mo159a(this.f74b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f75c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0062c.m94a(entry.getKey(), this.f76d.mo158a(this.f74b, 0)) && C0062c.m94a(entry.getValue(), this.f76d.mo158a(this.f74b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.f75c) {
            Object a = this.f76d.mo158a(this.f74b, 0);
            Object a2 = this.f76d.mo158a(this.f74b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
