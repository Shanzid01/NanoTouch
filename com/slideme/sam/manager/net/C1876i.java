package com.slideme.sam.manager.net;

import com.slideme.sam.manager.util.C1920k;

/* compiled from: NetworkUtils */
class C1876i implements Runnable {
    final /* synthetic */ C1867a f3406a;

    C1876i(C1867a c1867a) {
        this.f3406a = c1867a;
    }

    public void run() {
        C1920k.m5782a(this.f3406a.f3381Z, "Network Timeout!", 0).show();
    }
}
