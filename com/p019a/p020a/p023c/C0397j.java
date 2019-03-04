package com.p019a.p020a.p023c;

import java.util.concurrent.Callable;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CrashlyticsCore */
class C0397j implements Callable<Void> {
    final /* synthetic */ C0395h f1354a;

    C0397j(C0395h c0395h) {
        this.f1354a = c0395h;
    }

    public /* synthetic */ Object call() {
        return m2807a();
    }

    public Void m2807a() {
        this.f1354a.f1336d.createNewFile();
        C0326f.m2298h().mo511a("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
