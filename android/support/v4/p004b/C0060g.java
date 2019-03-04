package android.support.v4.p004b;

import android.support.v4.b.g$android.support.v4.b.i;
import android.support.v4.b.g$android.support.v4.b.j;
import android.support.v4.b.g$android.support.v4.b.l;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
abstract class C0060g<K, V> {
    i f57b;
    j f58c;
    l f59d;

    protected abstract int mo156a();

    protected abstract int mo157a(Object obj);

    protected abstract Object mo158a(int i, int i2);

    protected abstract V mo159a(int i, V v);

    protected abstract void mo160a(int i);

    protected abstract void mo161a(K k, V v);

    protected abstract int mo162b(Object obj);

    protected abstract Map<K, V> mo163b();

    protected abstract void mo164c();

    C0060g() {
    }

    public static <K, V> boolean m64a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m66b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m67c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m77b(int i) {
        int a = mo156a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo158a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m74a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo156a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo158a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m65a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m79d() {
        if (this.f57b == null) {
            this.f57b = new C0067i(this);
        }
        return this.f57b;
    }

    public Set<K> m80e() {
        if (this.f58c == null) {
            this.f58c = new C0068j(this);
        }
        return this.f58c;
    }

    public Collection<V> m81f() {
        if (this.f59d == null) {
            this.f59d = new C0070l(this);
        }
        return this.f59d;
    }
}
