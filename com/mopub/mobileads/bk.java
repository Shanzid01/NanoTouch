package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: MraidDisplayController */
class bk extends BroadcastReceiver {
    final /* synthetic */ bb f2452a;
    private int f2453b;
    private Context f2454c;

    bk(bb bbVar) {
        this.f2452a = bbVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (m4581b() && intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
            int a = this.f2452a.m4555o();
            if (a != this.f2453b) {
                this.f2453b = a;
                this.f2452a.m4535a(this.f2453b);
            }
        }
    }

    private boolean m4581b() {
        return this.f2454c != null;
    }

    public void m4583a(Context context) {
        this.f2454c = context;
        context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    public void m4582a() {
        this.f2454c.unregisterReceiver(this);
        this.f2454c = null;
    }
}
