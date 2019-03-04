package com.google.analytics.tracking.android;

/* compiled from: AdHitIdGenerator */
class C0757a {
    private boolean f1964a;

    C0757a() {
        try {
            boolean z;
            if (Class.forName("com.google.ads.AdRequest") != null) {
                z = true;
            } else {
                z = false;
            }
            this.f1964a = z;
        } catch (ClassNotFoundException e) {
            this.f1964a = false;
        }
    }

    int m3742a() {
        if (this.f1964a) {
            return C0760b.m3831a().m3832b();
        }
        return 0;
    }
}
