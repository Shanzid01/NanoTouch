package android.support.v7.widget;

import android.util.SparseIntArray;

/* compiled from: GridLayoutManager */
public abstract class C0190s {
    final SparseIntArray f716a;
    private boolean f717b;

    public abstract int m1798a(int i);

    public void m1800a() {
        this.f716a.clear();
    }

    int m1799a(int i, int i2) {
        if (!this.f717b) {
            return m1802b(i, i2);
        }
        int i3 = this.f716a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = m1802b(i, i2);
        this.f716a.put(i, i3);
        return i3;
    }

    public int m1802b(int i, int i2) {
        int a = m1798a(i);
        if (a == i2) {
            return 0;
        }
        int b;
        int a2;
        int i3;
        if (this.f717b && this.f716a.size() > 0) {
            b = m1801b(i);
            if (b >= 0) {
                a2 = this.f716a.get(b) + m1798a(b);
                b++;
                i3 = b;
                while (i3 < i) {
                    b = m1798a(i3);
                    a2 += b;
                    if (a2 == i2) {
                        b = 0;
                    } else if (a2 <= i2) {
                        b = a2;
                    }
                    i3++;
                    a2 = b;
                }
                if (a2 + a > i2) {
                    return a2;
                }
                return 0;
            }
        }
        b = 0;
        a2 = 0;
        i3 = b;
        while (i3 < i) {
            b = m1798a(i3);
            a2 += b;
            if (a2 == i2) {
                b = 0;
            } else if (a2 <= i2) {
                b = a2;
            }
            i3++;
            a2 = b;
        }
        if (a2 + a > i2) {
            return 0;
        }
        return a2;
    }

    int m1801b(int i) {
        int i2 = 0;
        int size = this.f716a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.f716a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        if (size < 0 || size >= this.f716a.size()) {
            return -1;
        }
        return this.f716a.keyAt(size);
    }

    public int m1803c(int i, int i2) {
        int a = m1798a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = m1798a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        if (i5 + a > i2) {
            return i4 + 1;
        }
        return i4;
    }
}
