package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AnswersEventsHandler */
class C0351i implements Runnable {
    final /* synthetic */ C0348f f1123a;

    C0351i(C0348f c0348f) {
        this.f1123a = c0348f;
    }

    public void run() {
        try {
            this.f1123a.f1113b.mo479b();
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to send events files", e);
        }
    }
}
