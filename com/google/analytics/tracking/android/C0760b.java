package com.google.analytics.tracking.android;

import java.util.Random;

/* compiled from: AdMobInfo */
class C0760b {
    private static final C0760b f2020a = new C0760b();
    private int f2021b;
    private Random f2022c = new Random();

    private C0760b() {
    }

    static C0760b m3831a() {
        return f2020a;
    }

    int m3832b() {
        this.f2021b = this.f2022c.nextInt(2147483646) + 1;
        return this.f2021b;
    }
}
