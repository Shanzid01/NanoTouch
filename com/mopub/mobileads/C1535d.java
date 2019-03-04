package com.mopub.mobileads;

import java.util.Map;

/* compiled from: AdLoadTask */
class C1535d extends C1534c {
    private Map<String, String> f2502b;

    public C1535d(AdViewController adViewController, Map<String, String> map) {
        super(adViewController);
        this.f2502b = map;
    }

    void mo4142a() {
        AdViewController adViewController = (AdViewController) this.a.get();
        if (adViewController != null && !adViewController.m4265n()) {
            adViewController.m4250c();
            adViewController.m4238a().mo4114a(this.f2502b);
        }
    }

    void mo4143b() {
        this.f2502b = null;
    }
}
