package android.support.v4.p004b;

import java.util.Map;

/* compiled from: SimpleArrayMap */
public class C0058q<K, V> {
    static Object[] f49b;
    static int f50c;
    static Object[] f51d;
    static int f52e;
    int[] f53f;
    Object[] f54g;
    int f55h;

    int m55a(Object obj, int i) {
        int i2 = this.f55h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0062c.m92a(this.f53f, i2, i);
        if (a < 0 || obj.equals(this.f54g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f53f[i3] == i) {
            if (obj.equals(this.f54g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f53f[a] == i) {
            if (obj.equals(this.f54g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m53a() {
        int i = this.f55h;
        if (i == 0) {
            return -1;
        }
        int a = C0062c.m92a(this.f53f, i, 0);
        if (a < 0 || this.f54g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f53f[i2] == 0) {
            if (this.f54g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f53f[a] == 0) {
            if (this.f54g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m52e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0059a.class) {
                if (f51d != null) {
                    objArr = f51d;
                    this.f54g = objArr;
                    f51d = (Object[]) objArr[0];
                    this.f53f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f52e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0059a.class) {
                if (f49b != null) {
                    objArr = f49b;
                    this.f54g = objArr;
                    f49b = (Object[]) objArr[0];
                    this.f53f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f50c--;
                    return;
                }
            }
        }
        this.f53f = new int[i];
        this.f54g = new Object[(i << 1)];
    }

    private static void m51a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0059a.class) {
                if (f52e < 10) {
                    objArr[0] = f51d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f51d = objArr;
                    f52e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0059a.class) {
                if (f50c < 10) {
                    objArr[0] = f49b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f49b = objArr;
                    f50c++;
                }
            }
        }
    }

    public C0058q() {
        this.f53f = C0062c.f61a;
        this.f54g = C0062c.f63c;
        this.f55h = 0;
    }

    public C0058q(int i) {
        if (i == 0) {
            this.f53f = C0062c.f61a;
            this.f54g = C0062c.f63c;
        } else {
            m52e(i);
        }
        this.f55h = 0;
    }

    public void clear() {
        if (this.f55h != 0) {
            C0058q.m51a(this.f53f, this.f54g, this.f55h);
            this.f53f = C0062c.f61a;
            this.f54g = C0062c.f63c;
            this.f55h = 0;
        }
    }

    public void m57a(int i) {
        if (this.f53f.length < i) {
            Object obj = this.f53f;
            Object obj2 = this.f54g;
            m52e(i);
            if (this.f55h > 0) {
                System.arraycopy(obj, 0, this.f53f, 0, this.f55h);
                System.arraycopy(obj2, 0, this.f54g, 0, this.f55h << 1);
            }
            C0058q.m51a(obj, obj2, this.f55h);
        }
    }

    public boolean containsKey(Object obj) {
        return m54a(obj) >= 0;
    }

    public int m54a(Object obj) {
        return obj == null ? m53a() : m55a(obj, obj.hashCode());
    }

    int m58b(Object obj) {
        int i = 1;
        int i2 = this.f55h * 2;
        Object[] objArr = this.f54g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m58b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m54a(obj);
        return a >= 0 ? this.f54g[(a << 1) + 1] : null;
    }

    public K m59b(int i) {
        return this.f54g[i << 1];
    }

    public V m60c(int i) {
        return this.f54g[(i << 1) + 1];
    }

    public V m56a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f54g[i2];
        this.f54g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f55h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m53a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m55a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f54g[i3];
            this.f54g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f55h >= this.f53f.length) {
            if (this.f55h >= 8) {
                i2 = this.f55h + (this.f55h >> 1);
            } else if (this.f55h < 4) {
                i2 = 4;
            }
            Object obj = this.f53f;
            Object obj2 = this.f54g;
            m52e(i2);
            if (this.f53f.length > 0) {
                System.arraycopy(obj, 0, this.f53f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f54g, 0, obj2.length);
            }
            C0058q.m51a(obj, obj2, this.f55h);
        }
        if (a < this.f55h) {
            System.arraycopy(this.f53f, a, this.f53f, a + 1, this.f55h - a);
            System.arraycopy(this.f54g, a << 1, this.f54g, (a + 1) << 1, (this.f55h - a) << 1);
        }
        this.f53f[a] = i;
        this.f54g[a << 1] = k;
        this.f54g[(a << 1) + 1] = v;
        this.f55h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m54a(obj);
        if (a >= 0) {
            return m61d(a);
        }
        return null;
    }

    public V m61d(int i) {
        int i2 = 8;
        V v = this.f54g[(i << 1) + 1];
        if (this.f55h <= 1) {
            C0058q.m51a(this.f53f, this.f54g, this.f55h);
            this.f53f = C0062c.f61a;
            this.f54g = C0062c.f63c;
            this.f55h = 0;
        } else if (this.f53f.length <= 8 || this.f55h >= this.f53f.length / 3) {
            this.f55h--;
            if (i < this.f55h) {
                System.arraycopy(this.f53f, i + 1, this.f53f, i, this.f55h - i);
                System.arraycopy(this.f54g, (i + 1) << 1, this.f54g, i << 1, (this.f55h - i) << 1);
            }
            this.f54g[this.f55h << 1] = null;
            this.f54g[(this.f55h << 1) + 1] = null;
        } else {
            if (this.f55h > 8) {
                i2 = this.f55h + (this.f55h >> 1);
            }
            Object obj = this.f53f;
            Object obj2 = this.f54g;
            m52e(i2);
            this.f55h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f53f, 0, i);
                System.arraycopy(obj2, 0, this.f54g, 0, i << 1);
            }
            if (i < this.f55h) {
                System.arraycopy(obj, i + 1, this.f53f, i, this.f55h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f54g, i << 1, (this.f55h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f55h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f55h) {
            try {
                Object b = m59b(i);
                Object c = m60c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f53f;
        Object[] objArr = this.f54g;
        int i = this.f55h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f55h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f55h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0058q b = m59b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m60c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
