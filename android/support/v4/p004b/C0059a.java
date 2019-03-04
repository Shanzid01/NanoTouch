package android.support.v4.p004b;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class C0059a<K, V> extends C0058q<K, V> implements Map<K, V> {
    C0060g<K, V> f56a;

    private C0060g<K, V> m62b() {
        if (this.f56a == null) {
            this.f56a = new C0061b(this);
        }
        return this.f56a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m57a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m63a(Collection<?> collection) {
        return C0060g.m67c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m62b().m79d();
    }

    public Set<K> keySet() {
        return m62b().m80e();
    }

    public Collection<V> values() {
        return m62b().m81f();
    }
}
