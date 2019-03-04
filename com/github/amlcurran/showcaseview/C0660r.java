package com.github.amlcurran.showcaseview;

import android.content.Context;

/* compiled from: ShotStateStore */
class C0660r {
    long f1652a = -1;
    private final Context f1653b;

    public C0660r(Context context) {
        this.f1653b = context;
    }

    boolean m3239a() {
        return m3240b() && this.f1653b.getSharedPreferences("showcase_internal", 0).getBoolean("hasShot" + this.f1652a, false);
    }

    boolean m3240b() {
        return this.f1652a != -1;
    }

    void m3241c() {
        if (m3240b()) {
            this.f1653b.getSharedPreferences("showcase_internal", 0).edit().putBoolean("hasShot" + this.f1652a, true).commit();
        }
    }

    void m3238a(long j) {
        this.f1652a = j;
    }
}
