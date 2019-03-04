package com.mopub.mobileads;

import android.view.View;

/* compiled from: AdViewController */
class C1541j implements Runnable {
    final /* synthetic */ AdViewController f2512a;
    private final /* synthetic */ View f2513b;

    C1541j(AdViewController adViewController, View view) {
        this.f2512a = adViewController;
        this.f2513b = view;
    }

    public void run() {
        MoPubView a = this.f2512a.m4238a();
        if (a != null) {
            a.removeAllViews();
            a.addView(this.f2513b, this.f2512a.m4233d(this.f2513b));
        }
    }
}
