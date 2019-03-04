package com.p019a.p020a.p023c;

import java.util.concurrent.Callable;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsCore */
class C0398k implements Callable<Boolean> {
    final /* synthetic */ C0395h f1355a;

    C0398k(C0395h c0395h) {
        this.f1355a = c0395h;
    }

    public /* synthetic */ Object call() {
        return m2808a();
    }

    public Boolean m2808a() {
        try {
            boolean delete = this.f1355a.f1336d.delete();
            C0326f.m2298h().mo511a("CrashlyticsCore", "Initialization marker file removed: " + delete);
            return Boolean.valueOf(delete);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
            return Boolean.valueOf(false);
        }
    }
}
