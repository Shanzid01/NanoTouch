package com.p019a.p020a.p022b;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0202s;
import p006b.p007a.p008a.p009a.p010a.p012b.C0213k;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p016e.C0274m;
import p006b.p007a.p008a.p009a.p010a.p017f.C0292c;
import p006b.p007a.p008a.p009a.p010a.p018g.C0299f;

/* compiled from: AbstractCheckForUpdatesController */
abstract class C0369a implements C0368l {
    private final AtomicBoolean f1151a;
    private final AtomicBoolean f1152b;
    private Context f1153c;
    private C0373e f1154d;
    private C0226z f1155e;
    private C0299f f1156f;
    private C0374f f1157g;
    private C0292c f1158h;
    private C0202s f1159i;
    private C0274m f1160j;
    private long f1161k;

    public C0369a() {
        this(false);
    }

    public C0369a(boolean z) {
        this.f1151a = new AtomicBoolean();
        this.f1161k = 0;
        this.f1152b = new AtomicBoolean(z);
    }

    public void mo548a(Context context, C0373e c0373e, C0226z c0226z, C0299f c0299f, C0374f c0374f, C0292c c0292c, C0202s c0202s, C0274m c0274m) {
        this.f1153c = context;
        this.f1154d = c0373e;
        this.f1155e = c0226z;
        this.f1156f = c0299f;
        this.f1157g = c0374f;
        this.f1158h = c0292c;
        this.f1159i = c0202s;
        this.f1160j = c0274m;
        if (m2520b()) {
            m2521c();
        }
    }

    protected boolean m2519a() {
        this.f1152b.set(true);
        return this.f1151a.get();
    }

    boolean m2520b() {
        this.f1151a.set(true);
        return this.f1152b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void m2521c() {
        synchronized (this.f1158h) {
            if (this.f1158h.mo500a().contains("last_update_check")) {
                this.f1158h.mo501a(this.f1158h.mo502b().remove("last_update_check"));
            }
        }
        long a = this.f1159i.mo466a();
        long j = ((long) this.f1156f.f946b) * 1000;
        C0326f.m2298h().mo511a("Beta", "Check for updates delay: " + j);
        C0326f.m2298h().mo511a("Beta", "Check for updates last check time: " + m2522d());
        j += m2522d();
        C0326f.m2298h().mo511a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                m2516e();
            } finally {
                m2517a(a);
            }
        } else {
            C0326f.m2298h().mo511a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void m2516e() {
        C0326f.m2298h().mo511a("Beta", "Performing update check");
        String a = new C0213k().m1889a(this.f1153c);
        new C0375g(this.f1154d, this.f1154d.m2536g(), this.f1156f.f945a, this.f1160j, new C0377i()).m2541a(a, this.f1155e.m1957a(a, this.f1157g.f1172d), this.f1157g);
    }

    void m2517a(long j) {
        this.f1161k = j;
    }

    long m2522d() {
        return this.f1161k;
    }
}
