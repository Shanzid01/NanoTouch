package android.support.v4.p004b;

import java.util.Iterator;

/* compiled from: MapCollections */
final class C0066h<T> implements Iterator<T> {
    final int f66a;
    int f67b;
    int f68c;
    boolean f69d = false;
    final /* synthetic */ C0060g f70e;

    C0066h(C0060g c0060g, int i) {
        this.f70e = c0060g;
        this.f66a = i;
        this.f67b = c0060g.mo156a();
    }

    public boolean hasNext() {
        return this.f68c < this.f67b;
    }

    public T next() {
        T a = this.f70e.mo158a(this.f68c, this.f66a);
        this.f68c++;
        this.f69d = true;
        return a;
    }

    public void remove() {
        if (this.f69d) {
            this.f68c--;
            this.f67b--;
            this.f69d = false;
            this.f70e.mo160a(this.f68c);
            return;
        }
        throw new IllegalStateException();
    }
}
