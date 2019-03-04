package com.p019a.p020a.p021a;

import android.annotation.SuppressLint;
import p006b.p007a.p008a.p009a.p010a.p017f.C0292c;

/* compiled from: AnswersPreferenceManager */
class C0356n {
    private final C0292c f1131a;

    public C0356n(C0292c c0292c) {
        this.f1131a = c0292c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m2477a() {
        this.f1131a.mo501a(this.f1131a.mo502b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean m2478b() {
        return this.f1131a.mo500a().getBoolean("analytics_launched", false);
    }
}
