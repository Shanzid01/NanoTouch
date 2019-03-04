package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: MoPubActivity */
class C1573y implements MoPubUriJavascriptFireFinishLoadListener {
    private final /* synthetic */ CustomEventInterstitialListener f2599a;

    C1573y(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f2599a = customEventInterstitialListener;
    }

    public void onInterstitialLoaded() {
        this.f2599a.onInterstitialLoaded();
    }
}
