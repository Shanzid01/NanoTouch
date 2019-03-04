package com.p019a.p020a.p023c;

import com.p019a.p020a.p023c.p024a.p025a.C0385f;

/* compiled from: NativeCrashWriter */
final class br extends bo {
    private final String f1287a;
    private final int f1288b;

    public br(C0385f c0385f, bp bpVar) {
        super(1, bpVar);
        this.f1287a = c0385f.f1203a;
        this.f1288b = c0385f.f1204b;
    }

    public int mo555a() {
        return (m2639d() ? C0393f.m2715b(1, C0389b.m2588a(this.f1287a)) : 0) + C0393f.m2720d(2, this.f1288b);
    }

    public void mo556a(C0393f c0393f) {
        if (m2639d()) {
            c0393f.m2737a(1, C0389b.m2588a(this.f1287a));
        }
        c0393f.m2735a(2, this.f1288b);
    }

    private boolean m2639d() {
        return this.f1287a != null && this.f1287a.length() > 0;
    }
}
