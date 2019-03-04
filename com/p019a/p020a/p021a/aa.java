package com.p019a.p020a.p021a;

import p006b.p007a.p008a.p009a.p010a.p013c.p014a.C0231e;

/* compiled from: RetryManager */
class aa {
    long f1060a;
    private C0231e f1061b;

    public aa(C0231e c0231e) {
        if (c0231e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f1061b = c0231e;
    }

    public boolean m2376a(long j) {
        return j - this.f1060a >= 1000000 * this.f1061b.m1976a();
    }

    public void m2377b(long j) {
        this.f1060a = j;
        this.f1061b = this.f1061b.m1977b();
    }

    public void m2375a() {
        this.f1060a = 0;
        this.f1061b = this.f1061b.m1978c();
    }
}
