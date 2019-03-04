package android.support.v7.widget;

/* compiled from: ChildHelper */
class C0177e {
    long f668a = 0;
    C0177e f669b;

    C0177e() {
    }

    void m1749a(int i) {
        if (i >= 64) {
            m1747b();
            this.f669b.m1749a(i - 64);
            return;
        }
        this.f668a |= 1 << i;
    }

    private void m1747b() {
        if (this.f669b == null) {
            this.f669b = new C0177e();
        }
    }

    void m1751b(int i) {
        if (i < 64) {
            this.f668a &= (1 << i) ^ -1;
        } else if (this.f669b != null) {
            this.f669b.m1751b(i - 64);
        }
    }

    boolean m1752c(int i) {
        if (i < 64) {
            return (this.f668a & (1 << i)) != 0;
        } else {
            m1747b();
            return this.f669b.m1752c(i - 64);
        }
    }

    void m1748a() {
        this.f668a = 0;
        if (this.f669b != null) {
            this.f669b.m1748a();
        }
    }

    void m1750a(int i, boolean z) {
        if (i >= 64) {
            m1747b();
            this.f669b.m1750a(i - 64, z);
            return;
        }
        boolean z2 = (this.f668a & Long.MIN_VALUE) != 0;
        long j = (1 << i) - 1;
        this.f668a = (((j ^ -1) & this.f668a) << 1) | (this.f668a & j);
        if (z) {
            m1749a(i);
        } else {
            m1751b(i);
        }
        if (z2 || this.f669b != null) {
            m1747b();
            this.f669b.m1750a(0, z2);
        }
    }

    boolean m1753d(int i) {
        if (i >= 64) {
            m1747b();
            return this.f669b.m1753d(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.f668a & j) != 0;
        this.f668a &= j ^ -1;
        j--;
        this.f668a = Long.rotateRight((j ^ -1) & this.f668a, 1) | (this.f668a & j);
        if (this.f669b == null) {
            return z;
        }
        if (this.f669b.m1752c(0)) {
            m1749a(63);
        }
        this.f669b.m1753d(0);
        return z;
    }

    int m1754e(int i) {
        if (this.f669b == null) {
            if (i >= 64) {
                return Long.bitCount(this.f668a);
            }
            return Long.bitCount(this.f668a & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.f668a & ((1 << i) - 1));
        } else {
            return this.f669b.m1754e(i - 64) + Long.bitCount(this.f668a);
        }
    }

    public String toString() {
        return this.f669b == null ? Long.toBinaryString(this.f668a) : this.f669b.toString() + "xx" + Long.toBinaryString(this.f668a);
    }
}
