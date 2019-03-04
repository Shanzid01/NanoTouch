package com.p019a.p020a.p023c;

/* compiled from: NativeCrashWriter */
abstract class bo {
    private final int f1261a;
    private final bo[] f1262b;

    public bo(int i, bo... boVarArr) {
        this.f1261a = i;
        if (boVarArr == null) {
            boVarArr = be.f1256b;
        }
        this.f1262b = boVarArr;
    }

    public int mo558b() {
        int c = m2621c();
        return (c + C0393f.m2729l(c)) + C0393f.m2728j(this.f1261a);
    }

    public int m2621c() {
        int a = mo555a();
        for (bo b : this.f1262b) {
            a += b.mo558b();
        }
        return a;
    }

    public void mo557b(C0393f c0393f) {
        c0393f.m2754g(this.f1261a, 2);
        c0393f.m2756k(m2621c());
        mo556a(c0393f);
        for (bo b : this.f1262b) {
            b.mo557b(c0393f);
        }
    }

    public int mo555a() {
        return 0;
    }

    public void mo556a(C0393f c0393f) {
    }
}
