package com.mopub.mobileads;

import android.widget.Toast;

/* compiled from: MraidDisplayController */
class bd implements Runnable {
    final /* synthetic */ bb f2434a;
    private final /* synthetic */ String f2435b;

    bd(bb bbVar, String str) {
        this.f2434a = bbVar;
        this.f2435b = str;
    }

    public void run() {
        Toast.makeText(this.f2434a.m4558r(), this.f2435b, 0).show();
    }
}
