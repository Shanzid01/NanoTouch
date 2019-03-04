package com.google.p043a.p045b;

import com.google.a.b.w$com.google.a.b.aa;
import com.google.a.b.w$com.google.a.b.y;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: LinkedTreeMap */
public final class C0726w<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f1885f = (!C0726w.class.desiredAssertionStatus());
    private static final Comparator<Comparable> f1886g = new C0727x();
    Comparator<? super K> f1887a;
    ad<K, V> f1888b;
    int f1889c;
    int f1890d;
    final ad<K, V> f1891e;
    private y f1892h;
    private aa f1893i;

    public C0726w() {
        this(f1886g);
    }

    public C0726w(Comparator<? super K> comparator) {
        this.f1889c = 0;
        this.f1890d = 0;
        this.f1891e = new ad();
        if (comparator == null) {
            comparator = f1886g;
        }
        this.f1887a = comparator;
    }

    public int size() {
        return this.f1889c;
    }

    public V get(Object obj) {
        ad a = m3648a(obj);
        return a != null ? a.f1829g : null;
    }

    public boolean containsKey(Object obj) {
        return m3648a(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        ad a = m3649a((Object) k, true);
        V v2 = a.f1829g;
        a.f1829g = v;
        return v2;
    }

    public void clear() {
        this.f1888b = null;
        this.f1889c = 0;
        this.f1890d++;
        ad adVar = this.f1891e;
        adVar.f1827e = adVar;
        adVar.f1826d = adVar;
    }

    public V remove(Object obj) {
        ad b = m3652b(obj);
        return b != null ? b.f1829g : null;
    }

    ad<K, V> m3649a(K k, boolean z) {
        int i;
        Comparator comparator = this.f1887a;
        ad<K, V> adVar = this.f1888b;
        if (adVar != null) {
            int compareTo;
            Comparable comparable = comparator == f1886g ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(adVar.f1828f) : comparator.compare(k, adVar.f1828f);
                if (compareTo == 0) {
                    return adVar;
                }
                ad<K, V> adVar2 = compareTo < 0 ? adVar.f1824b : adVar.f1825c;
                if (adVar2 == null) {
                    break;
                }
                adVar = adVar2;
            }
            int i2 = compareTo;
            ad adVar3 = adVar;
            i = i2;
        } else {
            ad<K, V> adVar4 = adVar;
            i = 0;
        }
        if (!z) {
            return null;
        }
        ad<K, V> adVar5;
        ad adVar6 = this.f1891e;
        if (adVar3 != null) {
            adVar5 = new ad(adVar3, k, adVar6, adVar6.f1827e);
            if (i < 0) {
                adVar3.f1824b = adVar5;
            } else {
                adVar3.f1825c = adVar5;
            }
            m3647b(adVar3, true);
        } else if (comparator != f1886g || (k instanceof Comparable)) {
            adVar5 = new ad(adVar3, k, adVar6, adVar6.f1827e);
            this.f1888b = adVar5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f1889c++;
        this.f1890d++;
        return adVar5;
    }

    ad<K, V> m3648a(Object obj) {
        ad<K, V> adVar = null;
        if (obj != null) {
            try {
                adVar = m3649a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return adVar;
    }

    ad<K, V> m3650a(Entry<?, ?> entry) {
        ad<K, V> a = m3648a(entry.getKey());
        Object obj = (a == null || !m3645a(a.f1829g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    private boolean m3645a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void m3651a(ad<K, V> adVar, boolean z) {
        int i = 0;
        if (z) {
            adVar.f1827e.f1826d = adVar.f1826d;
            adVar.f1826d.f1827e = adVar.f1827e;
        }
        ad adVar2 = adVar.f1824b;
        ad adVar3 = adVar.f1825c;
        ad adVar4 = adVar.f1823a;
        if (adVar2 == null || adVar3 == null) {
            if (adVar2 != null) {
                m3644a((ad) adVar, adVar2);
                adVar.f1824b = null;
            } else if (adVar3 != null) {
                m3644a((ad) adVar, adVar3);
                adVar.f1825c = null;
            } else {
                m3644a((ad) adVar, null);
            }
            m3647b(adVar4, false);
            this.f1889c--;
            this.f1890d++;
            return;
        }
        int i2;
        adVar2 = adVar2.f1830h > adVar3.f1830h ? adVar2.m3577b() : adVar3.m3576a();
        m3651a(adVar2, false);
        adVar4 = adVar.f1824b;
        if (adVar4 != null) {
            i2 = adVar4.f1830h;
            adVar2.f1824b = adVar4;
            adVar4.f1823a = adVar2;
            adVar.f1824b = null;
        } else {
            i2 = 0;
        }
        adVar4 = adVar.f1825c;
        if (adVar4 != null) {
            i = adVar4.f1830h;
            adVar2.f1825c = adVar4;
            adVar4.f1823a = adVar2;
            adVar.f1825c = null;
        }
        adVar2.f1830h = Math.max(i2, i) + 1;
        m3644a((ad) adVar, adVar2);
    }

    ad<K, V> m3652b(Object obj) {
        ad a = m3648a(obj);
        if (a != null) {
            m3651a(a, true);
        }
        return a;
    }

    private void m3644a(ad<K, V> adVar, ad<K, V> adVar2) {
        ad adVar3 = adVar.f1823a;
        adVar.f1823a = null;
        if (adVar2 != null) {
            adVar2.f1823a = adVar3;
        }
        if (adVar3 == null) {
            this.f1888b = adVar2;
        } else if (adVar3.f1824b == adVar) {
            adVar3.f1824b = adVar2;
        } else if (f1885f || adVar3.f1825c == adVar) {
            adVar3.f1825c = adVar2;
        } else {
            throw new AssertionError();
        }
    }

    private void m3647b(ad<K, V> adVar, boolean z) {
        ad adVar2;
        while (adVar2 != null) {
            int i;
            ad adVar3 = adVar2.f1824b;
            ad adVar4 = adVar2.f1825c;
            int i2 = adVar3 != null ? adVar3.f1830h : 0;
            if (adVar4 != null) {
                i = adVar4.f1830h;
            } else {
                i = 0;
            }
            int i3 = i2 - i;
            ad adVar5;
            if (i3 == -2) {
                adVar3 = adVar4.f1824b;
                adVar5 = adVar4.f1825c;
                if (adVar5 != null) {
                    i2 = adVar5.f1830h;
                } else {
                    i2 = 0;
                }
                if (adVar3 != null) {
                    i = adVar3.f1830h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == -1 || (i == 0 && !z)) {
                    m3643a(adVar2);
                } else if (f1885f || i == 1) {
                    m3646b(adVar4);
                    m3643a(adVar2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                adVar4 = adVar3.f1824b;
                adVar5 = adVar3.f1825c;
                i2 = adVar5 != null ? adVar5.f1830h : 0;
                if (adVar4 != null) {
                    i = adVar4.f1830h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == 1 || (i == 0 && !z)) {
                    m3646b(adVar2);
                } else if (f1885f || i == -1) {
                    m3643a(adVar3);
                    m3646b(adVar2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                adVar2.f1830h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f1885f || i3 == -1 || i3 == 1) {
                adVar2.f1830h = Math.max(i2, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            adVar2 = adVar2.f1823a;
        }
    }

    private void m3643a(ad<K, V> adVar) {
        int i;
        int i2 = 0;
        ad adVar2 = adVar.f1824b;
        ad adVar3 = adVar.f1825c;
        ad adVar4 = adVar3.f1824b;
        ad adVar5 = adVar3.f1825c;
        adVar.f1825c = adVar4;
        if (adVar4 != null) {
            adVar4.f1823a = adVar;
        }
        m3644a((ad) adVar, adVar3);
        adVar3.f1824b = adVar;
        adVar.f1823a = adVar3;
        if (adVar2 != null) {
            i = adVar2.f1830h;
        } else {
            i = 0;
        }
        adVar.f1830h = Math.max(i, adVar4 != null ? adVar4.f1830h : 0) + 1;
        int i3 = adVar.f1830h;
        if (adVar5 != null) {
            i2 = adVar5.f1830h;
        }
        adVar3.f1830h = Math.max(i3, i2) + 1;
    }

    private void m3646b(ad<K, V> adVar) {
        int i;
        int i2 = 0;
        ad adVar2 = adVar.f1824b;
        ad adVar3 = adVar.f1825c;
        ad adVar4 = adVar2.f1824b;
        ad adVar5 = adVar2.f1825c;
        adVar.f1824b = adVar5;
        if (adVar5 != null) {
            adVar5.f1823a = adVar;
        }
        m3644a((ad) adVar, adVar2);
        adVar2.f1825c = adVar;
        adVar.f1823a = adVar2;
        if (adVar3 != null) {
            i = adVar3.f1830h;
        } else {
            i = 0;
        }
        adVar.f1830h = Math.max(i, adVar5 != null ? adVar5.f1830h : 0) + 1;
        int i3 = adVar.f1830h;
        if (adVar4 != null) {
            i2 = adVar4.f1830h;
        }
        adVar2.f1830h = Math.max(i3, i2) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.f1892h;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> c0728y = new C0728y(this);
        this.f1892h = c0728y;
        return c0728y;
    }

    public Set<K> keySet() {
        Set set = this.f1893i;
        if (set != null) {
            return set;
        }
        Set<K> aaVar = new aa(this);
        this.f1893i = aaVar;
        return aaVar;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
}
