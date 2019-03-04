package android.support.v4.p004b;

/* compiled from: SparseArrayCompat */
public class C0075r<E> implements Cloneable {
    private static final Object f82a = new Object();
    private boolean f83b;
    private int[] f84c;
    private Object[] f85d;
    private int f86e;

    public /* synthetic */ Object clone() {
        return m108a();
    }

    public C0075r() {
        this(10);
    }

    public C0075r(int i) {
        this.f83b = false;
        if (i == 0) {
            this.f84c = C0062c.f61a;
            this.f85d = C0062c.f63c;
        } else {
            int a = C0062c.m91a(i);
            this.f84c = new int[a];
            this.f85d = new Object[a];
        }
        this.f86e = 0;
    }

    public C0075r<E> m108a() {
        try {
            C0075r<E> c0075r = (C0075r) super.clone();
            try {
                c0075r.f84c = (int[]) this.f84c.clone();
                c0075r.f85d = (Object[]) this.f85d.clone();
                return c0075r;
            } catch (CloneNotSupportedException e) {
                return c0075r;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m109a(int i) {
        return m110a(i, null);
    }

    public E m110a(int i, E e) {
        int a = C0062c.m92a(this.f84c, this.f86e, i);
        return (a < 0 || this.f85d[a] == f82a) ? e : this.f85d[a];
    }

    public void m112b(int i) {
        int a = C0062c.m92a(this.f84c, this.f86e, i);
        if (a >= 0 && this.f85d[a] != f82a) {
            this.f85d[a] = f82a;
            this.f83b = true;
        }
    }

    public void m115c(int i) {
        m112b(i);
    }

    public void m116d(int i) {
        if (this.f85d[i] != f82a) {
            this.f85d[i] = f82a;
            this.f83b = true;
        }
    }

    private void m107d() {
        int i = this.f86e;
        int[] iArr = this.f84c;
        Object[] objArr = this.f85d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f82a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f83b = false;
        this.f86e = i2;
    }

    public void m113b(int i, E e) {
        int a = C0062c.m92a(this.f84c, this.f86e, i);
        if (a >= 0) {
            this.f85d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f86e || this.f85d[a] != f82a) {
            if (this.f83b && this.f86e >= this.f84c.length) {
                m107d();
                a = C0062c.m92a(this.f84c, this.f86e, i) ^ -1;
            }
            if (this.f86e >= this.f84c.length) {
                int a2 = C0062c.m91a(this.f86e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f84c, 0, obj, 0, this.f84c.length);
                System.arraycopy(this.f85d, 0, obj2, 0, this.f85d.length);
                this.f84c = obj;
                this.f85d = obj2;
            }
            if (this.f86e - a != 0) {
                System.arraycopy(this.f84c, a, this.f84c, a + 1, this.f86e - a);
                System.arraycopy(this.f85d, a, this.f85d, a + 1, this.f86e - a);
            }
            this.f84c[a] = i;
            this.f85d[a] = e;
            this.f86e++;
            return;
        }
        this.f84c[a] = i;
        this.f85d[a] = e;
    }

    public int m111b() {
        if (this.f83b) {
            m107d();
        }
        return this.f86e;
    }

    public int m117e(int i) {
        if (this.f83b) {
            m107d();
        }
        return this.f84c[i];
    }

    public E m118f(int i) {
        if (this.f83b) {
            m107d();
        }
        return this.f85d[i];
    }

    public int m119g(int i) {
        if (this.f83b) {
            m107d();
        }
        return C0062c.m92a(this.f84c, this.f86e, i);
    }

    public void m114c() {
        int i = this.f86e;
        Object[] objArr = this.f85d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f86e = 0;
        this.f83b = false;
    }

    public String toString() {
        if (m111b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f86e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f86e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m117e(i));
            stringBuilder.append('=');
            C0075r f = m118f(i);
            if (f != this) {
                stringBuilder.append(f);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
