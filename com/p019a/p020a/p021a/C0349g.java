package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p018g.C0295b;

/* compiled from: AnswersEventsHandler */
class C0349g implements Runnable {
    final /* synthetic */ C0295b f1119a;
    final /* synthetic */ String f1120b;
    final /* synthetic */ C0348f f1121c;

    C0349g(C0348f c0348f, C0295b c0295b, String str) {
        this.f1121c = c0348f;
        this.f1119a = c0295b;
        this.f1120b = str;
    }

    public void run() {
        try {
            this.f1121c.f1113b.mo545a(this.f1119a, this.f1120b);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to set analytics settings data", e);
        }
    }
}
