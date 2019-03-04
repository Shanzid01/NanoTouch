package com.google.analytics.tracking.android;

import java.util.TimerTask;

/* compiled from: GAServiceProxy */
class ae extends TimerTask {
    final /* synthetic */ C0781y f1968a;

    private ae(C0781y c0781y) {
        this.f1968a = c0781y;
    }

    public void run() {
        if (this.f1968a.f2110b == ac.CONNECTING) {
            this.f1968a.m3988i();
        }
    }
}
