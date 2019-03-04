package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.R;

/* compiled from: ApplicationDetailsFragment */
class C1772v implements Runnable {
    final /* synthetic */ C1771u f3158a;
    private final /* synthetic */ String f3159b;

    C1772v(C1771u c1771u, String str) {
        this.f3158a = c1771u;
        this.f3159b = str;
    }

    public void run() {
        if (this.f3158a.f3156a.f2981E != null) {
            this.f3158a.f3156a.f2981E.m5997a(this.f3158a.f3156a.getString(R.string.sharearn_prompt));
            this.f3158a.f3156a.f2981E.setOnClickListener(new C1773w(this, this.f3159b));
            this.f3158a.f3156a.f2981E.m5998b();
        }
    }
}
