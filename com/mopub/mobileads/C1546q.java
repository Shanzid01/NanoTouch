package com.mopub.mobileads;

import android.util.Log;

/* compiled from: CustomEventBannerAdapter */
class C1546q implements Runnable {
    final /* synthetic */ CustomEventBannerAdapter f2518a;

    C1546q(CustomEventBannerAdapter customEventBannerAdapter) {
        this.f2518a = customEventBannerAdapter;
    }

    public void run() {
        Log.d("MoPub", "Third-party network timed out.");
        this.f2518a.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f2518a.m4299b();
    }
}
