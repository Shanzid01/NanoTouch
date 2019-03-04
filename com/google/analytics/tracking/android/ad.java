package com.google.analytics.tracking.android;

import java.util.TimerTask;

/* compiled from: GAServiceProxy */
class ad extends TimerTask {
    final /* synthetic */ C0781y f1967a;

    private ad(C0781y c0781y) {
        this.f1967a = c0781y;
    }

    public void run() {
        if (this.f1967a.f2110b == ac.CONNECTED_SERVICE && this.f1967a.f2116h.isEmpty() && this.f1967a.f2109a + this.f1967a.f2124p < this.f1967a.f2123o.mo1198a()) {
            av.m3818e("Disconnecting due to inactivity");
            this.f1967a.m3992k();
            return;
        }
        this.f1967a.f2120l.schedule(new ad(this.f1967a), this.f1967a.f2124p);
    }
}
