package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AnswersEventsHandler */
class C0350h implements Runnable {
    final /* synthetic */ C0348f f1122a;

    C0350h(C0348f c0348f) {
        this.f1122a = c0348f;
    }

    public void run() {
        try {
            ah ahVar = this.f1122a.f1113b;
            this.f1122a.f1113b = new C0360r();
            ahVar.mo480c();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to disable events", e);
        }
    }
}
