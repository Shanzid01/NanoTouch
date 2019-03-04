package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzbh.zza;

@zzgi
public final class zzav extends zza {
    private final AdListener zzoK;

    public zzav(AdListener adListener) {
        this.zzoK = adListener;
    }

    public void onAdClosed() {
        this.zzoK.onAdClosed();
    }

    public void onAdFailedToLoad(int i) {
        this.zzoK.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication() {
        this.zzoK.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.zzoK.onAdLoaded();
    }

    public void onAdOpened() {
        this.zzoK.onAdOpened();
    }
}
