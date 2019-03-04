package android.support.v4.p004b;

import java.util.Map;

/* compiled from: ArrayMap */
class C0061b extends C0060g<K, V> {
    final /* synthetic */ C0059a f60a;

    C0061b(C0059a c0059a) {
        this.f60a = c0059a;
    }

    protected int mo156a() {
        return this.f60a.h;
    }

    protected Object mo158a(int i, int i2) {
        return this.f60a.g[(i << 1) + i2];
    }

    protected int mo157a(Object obj) {
        return this.f60a.m54a(obj);
    }

    protected int mo162b(Object obj) {
        return this.f60a.m58b(obj);
    }

    protected Map<K, V> mo163b() {
        return this.f60a;
    }

    protected void mo161a(K k, V v) {
        this.f60a.put(k, v);
    }

    protected V mo159a(int i, V v) {
        return this.f60a.m56a(i, (Object) v);
    }

    protected void mo160a(int i) {
        this.f60a.m61d(i);
    }

    protected void mo164c() {
        this.f60a.clear();
    }
}
