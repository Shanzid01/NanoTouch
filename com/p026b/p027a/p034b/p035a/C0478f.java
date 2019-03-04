package com.p026b.p027a.p034b.p035a;

/* compiled from: ImageSize */
public class C0478f {
    private final int f1428a;
    private final int f1429b;

    public C0478f(int i, int i2) {
        this.f1428a = i;
        this.f1429b = i2;
    }

    public C0478f(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f1428a = i;
            this.f1429b = i2;
            return;
        }
        this.f1428a = i2;
        this.f1429b = i;
    }

    public int m2967a() {
        return this.f1428a;
    }

    public int m2970b() {
        return this.f1429b;
    }

    public C0478f m2969a(int i) {
        return new C0478f(this.f1428a / i, this.f1429b / i);
    }

    public C0478f m2968a(float f) {
        return new C0478f((int) (((float) this.f1428a) * f), (int) (((float) this.f1429b) * f));
    }

    public String toString() {
        return new StringBuilder(this.f1428a).append("x").append(this.f1429b).toString();
    }
}
