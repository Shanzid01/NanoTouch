package com.mopub.mobileads;

import android.util.Log;

/* compiled from: CustomEventInterstitialAdapter */
class C1547r implements Runnable {
    final /* synthetic */ CustomEventInterstitialAdapter f2519a;

    C1547r(CustomEventInterstitialAdapter customEventInterstitialAdapter) {
        this.f2519a = customEventInterstitialAdapter;
    }

    public void run() {
        Log.d("MoPub", "Third-party network timed out.");
        this.f2519a.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f2519a.m4307b();
    }
}
