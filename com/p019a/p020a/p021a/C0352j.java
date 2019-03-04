package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AnswersEventsHandler */
class C0352j implements Runnable {
    final /* synthetic */ C0348f f1124a;

    C0352j(C0348f c0348f) {
        this.f1124a = c0348f;
    }

    public void run() {
        try {
            am a = this.f1124a.f1117f.m2412a();
            ae a2 = this.f1124a.f1116e.m2469a();
            a2.m2071a(this.f1124a);
            this.f1124a.f1113b = new C0361s(this.f1124a.f1114c, this.f1124a.f1115d, this.f1124a.f1112a, a2, this.f1124a.f1118g, a);
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Answers", "Failed to enable events", e);
        }
    }
}
