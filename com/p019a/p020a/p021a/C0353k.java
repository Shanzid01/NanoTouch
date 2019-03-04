package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AnswersEventsHandler */
class C0353k implements Runnable {
    final /* synthetic */ ak f1125a;
    final /* synthetic */ boolean f1126b;
    final /* synthetic */ C0348f f1127c;

    C0353k(C0348f c0348f, ak akVar, boolean z) {
        this.f1127c = c0348f;
        this.f1125a = akVar;
        this.f1126b = z;
    }

    public void run() {
        try {
            this.f1127c.f1113b.mo546a(this.f1125a);
            if (this.f1126b) {
                this.f1127c.f1113b.mo482e();
            }
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to process event", e);
        }
    }
}
